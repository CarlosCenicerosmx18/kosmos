package com.kosmos.citas.service;

import com.kosmos.citas.model.Citas;
import com.kosmos.citas.repository.CitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CitaService {

    private final CitasRepository citaRepository;

    @Autowired
    public CitaService(CitasRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Citas> obtenerTodasLasCitas() {
        return citaRepository.findAll();
    }

    public Optional<Citas> obtenerCitaPorId(Long id) {
        return citaRepository.findById(id);
    }

    public String crearCita(Citas cita) {
        List<Citas> citasAnteriores = citaRepository.findAll();
        for (Citas c: citasAnteriores) {
            if(Objects.equals(cita.getHorarioConsulta(), c.getHorarioConsulta())){
               return "Horario no dispónible";
            }
            if(Objects.equals(cita.getDoctor().getDoctor_id(), c.getDoctor().getDoctor_id())){
                return "Doctor no dispónible";
            }
            citaRepository.save(cita);

        }
        return "{Cita agendada}";
    }

    public Citas actualizarCita(Long id, Citas citaActualizada) {
        Optional<Citas> citaExistenteOptional = citaRepository.findById(id);

        if (citaExistenteOptional.isPresent()) {
            Citas citaExistente = citaExistenteOptional.get();
            citaExistente.setConsultorio(citaActualizada.getConsultorio());
            citaExistente.setDoctor(citaActualizada.getDoctor());
            citaExistente.setHorarioConsulta(citaActualizada.getHorarioConsulta());
            citaExistente.setNombrePaciente(citaActualizada.getNombrePaciente());

            return citaRepository.save(citaExistente);
        }

        // Manejar el caso en el que la cita no existe
        return null;
    }

    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }
}
