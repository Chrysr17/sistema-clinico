package com.clinica.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "receta")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta")
    private Integer idReceta;

    @Column(name = "fecha")
    private Timestamp fecha;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL)
    private List<RecetaDetalle> recetaDetalles;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL)
    private List<RecetaAnalisis> recetaAnalisis;

    @PrePersist
    private void prePersist(){
        fecha = new Timestamp(System.currentTimeMillis());
    }

    public Receta() {
    }

    public Receta(Integer idReceta, Timestamp fecha, Paciente paciente, List<RecetaDetalle> recetaDetalles, List<RecetaAnalisis> recetaAnalisis, Medico medico) {
        this.idReceta = idReceta;
        this.fecha = fecha;
        this.paciente = paciente;
        this.recetaDetalles = recetaDetalles;
        this.recetaAnalisis = recetaAnalisis;
        this.medico = medico;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<RecetaDetalle> getRecetaDetalles() {
        return recetaDetalles;
    }

    public void setRecetaDetalles(List<RecetaDetalle> recetaDetalles) {
        this.recetaDetalles = recetaDetalles;
    }

    public List<RecetaAnalisis> getRecetaAnalisis() {
        return recetaAnalisis;
    }

    public void setRecetaAnalisis(List<RecetaAnalisis> recetaAnalisis) {
        this.recetaAnalisis = recetaAnalisis;
    }
}
