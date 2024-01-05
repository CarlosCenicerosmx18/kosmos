package com.kosmos.citas.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consultorio_id")
    private Consultorio consultorio;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioConsulta;

    private String nombrePaciente;


    public Citas() {
    }


    public Citas(Consultorio consultorio, Doctor doctor, Date horarioConsulta, String nombrePaciente) {
        this.consultorio = consultorio;
        this.doctor = doctor;
        this.horarioConsulta = horarioConsulta;
        this.nombrePaciente = nombrePaciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(Date horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

}