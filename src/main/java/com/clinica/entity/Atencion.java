package com.clinica.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "atencion")
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atencion")
    private Integer idAtencion;

    @ManyToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    @OneToOne
    @JoinColumn(name = "id_diagnostico", nullable = false)
    private Diagnostico diagnostico;

    @OneToOne
    @JoinColumn(name = "id_tratamiento", nullable = false)
    private Tratamiento tratamiento;

    @OneToOne
    @JoinColumn(name = "id_receta", nullable = false)
    private Receta receta;

    @Column(name = "fecha_atencion", nullable = false)
    private Timestamp fechaAtencion;

    @Column(name = "observaciones_generales", columnDefinition = "TEXT")
    private String observacionesGenerales;

    public Atencion() {
    }

    public Atencion(Integer idAtencion, Cita cita, Diagnostico diagnostico, Receta receta, Tratamiento tratamiento, Timestamp fechaAtencion, String observacionesGenerales) {
        this.idAtencion = idAtencion;
        this.cita = cita;
        this.diagnostico = diagnostico;
        this.receta = receta;
        this.tratamiento = tratamiento;
        this.fechaAtencion = fechaAtencion;
        this.observacionesGenerales = observacionesGenerales;
    }

    public Integer getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(Integer idAtencion) {
        this.idAtencion = idAtencion;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Timestamp getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Timestamp fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getObservacionesGenerales() {
        return observacionesGenerales;
    }

    public void setObservacionesGenerales(String observacionesGenerales) {
        this.observacionesGenerales = observacionesGenerales;
    }
}
