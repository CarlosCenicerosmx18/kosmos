package com.kosmos.citas.controller;

import com.kosmos.citas.model.Doctor;
import com.kosmos.citas.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public List<Doctor> obtenerDoctores() {
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Doctor obtenerDoctorPorId(@PathVariable Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Doctor crearDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @PutMapping("/{id}")
    public Doctor actualizarDoctor(@PathVariable Long id, @RequestBody Doctor doctorActualizado) {
        Doctor doctorExistente = doctorRepository.findById(id).orElse(null);

        if (doctorExistente != null) {
            doctorExistente.setNombre(doctorActualizado.getNombre());
            doctorExistente.setApellidoPaterno(doctorActualizado.getApellidoPaterno());
            doctorExistente.setApellidoMaterno(doctorActualizado.getApellidoMaterno());
            doctorExistente.setEspecialidad(doctorActualizado.getEspecialidad());

            return doctorRepository.save(doctorExistente);
        }

        return null;
    }
    @DeleteMapping("/{id}")
    public void eliminarDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
    }
}