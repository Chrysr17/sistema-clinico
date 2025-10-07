package com.clinica.entity;

import java.io.Serializable;
import java.util.Objects;

public class RecetaDetalleId implements Serializable {
    private Integer receta;
    private Integer medicamento;

    public RecetaDetalleId(){

    }

    public RecetaDetalleId(Integer receta, Integer medicamento) {
        this.receta = receta;
        this.medicamento = medicamento;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecetaDetalleId)) return false;
        RecetaDetalleId that = (RecetaDetalleId) o;
        return Objects.equals(receta, that.receta) &&
                Objects.equals(medicamento, that.medicamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receta, medicamento);
    }

    public Integer getReceta() {
        return receta;
    }

    public void setReceta(Integer receta) {
        this.receta = receta;
    }

    public Integer getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Integer medicamento) {
        this.medicamento = medicamento;
    }
}
