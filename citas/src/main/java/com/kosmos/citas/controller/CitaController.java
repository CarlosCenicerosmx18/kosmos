package com.kosmos.citas.controller;
import com.kosmos.citas.model.Citas;
import com.kosmos.citas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<Citas> obtenerTodasLasCitas() {
        return citaService.obtenerTodasLasCitas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Citas> obtenerCitaPorId(@PathVariable Long id) {
        Optional<Citas> cita = citaService.obtenerCitaPorId(id);
        return cita.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public String crearCita(@RequestBody Citas cita) {
        return citaService.crearCita(cita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Citas> actualizarCita(@PathVariable Long id, @RequestBody Citas citaActualizada) {
        Citas citaActualizadaEntity = citaService.actualizarCita(id, citaActualizada);

        if (citaActualizadaEntity != null) {
            return ResponseEntity.ok(citaActualizadaEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        citaService.eliminarCita(id);
        return ResponseEntity.noContent().build();
    }
}
