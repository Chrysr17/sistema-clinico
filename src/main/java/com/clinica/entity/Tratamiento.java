package com.clinica.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tratamiento")
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tratamiento")
    private Integer idTratamiento;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_diagnostico")
    private Diagnostico diagnostico;

    public Tratamiento() {
    }

    public Tratamiento(Integer idTramiento, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Diagnostico diagnostico) {
        this.idTratamiento = idTramiento;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.diagnostico = diagnostico;
    }

    public Integer getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

}
