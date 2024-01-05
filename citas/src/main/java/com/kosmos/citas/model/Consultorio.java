package com.kosmos.citas.model;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Consultorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultorio_id;

    private int numeroConsultorio;
    private int piso;

    @OneToMany(mappedBy = "consultorio")
    private List<Citas> citas;
    public Consultorio() {
    }

    public Consultorio(Long id, int numeroConsultorio, int piso) {
        this.consultorio_id = id;
        this.numeroConsultorio = numeroConsultorio;
        this.piso = piso;
    }

    public Long getConsultorio_id() {
        return consultorio_id;
    }

    public void setConsultorio_id(Long consultorio_id) {
        this.consultorio_id = consultorio_id;
    }

    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }

    public void setNumeroConsultorio(int numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
}