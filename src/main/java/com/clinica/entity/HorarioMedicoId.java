package com.clinica.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class HorarioMedicoId implements Serializable{
	
    private Integer idHorario;
    private Integer idMedico;

    public HorarioMedicoId() {}

    public HorarioMedicoId(Integer idHorario, Integer idMedico) {
        this.idHorario = idHorario;
        this.idMedico = idMedico;
    }

    // Getters y Setters

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    // hashCode y equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HorarioMedicoId)) return false;
        HorarioMedicoId that = (HorarioMedicoId) o;
        return Objects.equals(idHorario, that.idHorario) && Objects.equals(idMedico, that.idMedico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHorario, idMedico);
    }

}
