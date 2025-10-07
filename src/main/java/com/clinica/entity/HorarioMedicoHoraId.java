package com.clinica.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;

public class HorarioMedicoHoraId implements Serializable {

    @Column(name = "id_horario")
    private Integer idHorario;

    @Column(name = "id_medico")
    private Integer idMedico;

    @Column(name = "id_hora")
    private Integer idHora;

    // Constructores
    public HorarioMedicoHoraId() {}

    public HorarioMedicoHoraId(Integer idHorario, Integer idMedico, Integer idHora) {
        this.idHorario = idHorario;
        this.idMedico = idMedico;
        this.idHora = idHora;
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

    public Integer getIdHora() {
        return idHora;
    }

    public void setIdHora(Integer idHora) {
        this.idHora = idHora;
    }

    // equals y hashCode (obligatorios para claves compuestas)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HorarioMedicoHoraId)) return false;
        HorarioMedicoHoraId that = (HorarioMedicoHoraId) o;
        return Objects.equals(idHorario, that.idHorario) &&
               Objects.equals(idMedico, that.idMedico) &&
               Objects.equals(idHora, that.idHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHorario, idMedico, idHora);
    }
}
