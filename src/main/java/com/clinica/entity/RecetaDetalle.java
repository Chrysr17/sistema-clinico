package com.clinica.entity;

import jakarta.persistence.*;

@Entity
@IdClass(RecetaDetalleId.class)
@Table(name = "receta_detalle")
public class RecetaDetalle {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_receta")
    private Receta receta;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_medicamento")
    private Medicamento medicamento;

    private String dosis;
    private String frecuencia;
    private String duracion;

    public RecetaDetalle() {
    }

    public RecetaDetalle(Receta receta, Medicamento medicamento, String dosis, String frecuencia, String duracion) {
        this.receta = receta;
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setId(RecetaDetalleId recetaDetalleId) {
        this.setId(recetaDetalleId);
    }
}
