package com.clinica.entity;

import jakarta.persistence.*;

@Entity
@IdClass(RecetaAnalisisId.class)
@Table(name = "receta_analisis")
public class RecetaAnalisis {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_receta")
    private Receta receta;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_analisis")
    private Analisis analisis;

    private String observaciones;

    public RecetaAnalisis() {
    }

    public RecetaAnalisis(Receta receta, Analisis analisis, String observaciones) {
        this.receta = receta;
        this.analisis = analisis;
        this.observaciones = observaciones;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Analisis getAnalisis() {
        return analisis;
    }

    public void setAnalisis(Analisis analisis) {
        this.analisis = analisis;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
