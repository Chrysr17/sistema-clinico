package com.clinica.entity;

import java.util.Objects;

public class RecetaAnalisisId {

    private Integer receta;
    private Integer analisis;

    public RecetaAnalisisId() {
    }

    public RecetaAnalisisId(Integer receta, Integer analisis) {
        this.receta = receta;
        this.analisis = analisis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecetaAnalisisId)) return false;
        RecetaAnalisisId that = (RecetaAnalisisId) o;
        return Objects.equals(receta, that.receta) &&
                Objects.equals(analisis, that.analisis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receta, analisis);
    }

    public Integer getReceta() {
        return receta;
    }

    public void setReceta(Integer receta) {
        this.receta = receta;
    }

    public Integer getAnalisis() {
        return analisis;
    }

    public void setAnalisis(Integer analisis) {
        this.analisis = analisis;
    }
}
