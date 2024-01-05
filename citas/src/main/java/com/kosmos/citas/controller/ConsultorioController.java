package com.kosmos.citas.controller;

import com.kosmos.citas.model.Consultorio;
import com.kosmos.citas.repository.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorios")
public class ConsultorioController {

    @Autowired
    private ConsultorioRepository consultorioRepository;


    @GetMapping
    public List<Consultorio> obtenerConsultorios() {
        return consultorioRepository.findAll();
    }


    @GetMapping("/{id}")
    public Consultorio obtenerConsultorioPorId(@PathVariable Long id) {
        return consultorioRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Consultorio crearConsultorio(@RequestBody Consultorio consultorio) {
        return consultorioRepository.save(consultorio);
    }

    @PutMapping("/{id}")
    public Consultorio actualizarConsultorio(@PathVariable Long id, @RequestBody Consultorio consultorioActualizado) {
        Consultorio consultorioExistente = consultorioRepository.findById(id).orElse(null);

        if (consultorioExistente != null) {
            consultorioExistente.setNumeroConsultorio(consultorioActualizado.getNumeroConsultorio());
            consultorioExistente.setPiso(consultorioActualizado.getPiso());

            return consultorioRepository.save(consultorioExistente);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarConsultorio(@PathVariable Long id) {
        consultorioRepository.deleteById(id);
    }
}
