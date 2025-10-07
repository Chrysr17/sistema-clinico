package com.clinica.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario_medico")
public class HorarioMedico {
	
    @EmbeddedId
    private HorarioMedicoId id;

    @ManyToOne
    @MapsId("idHorario")
    @JoinColumn(name = "id_horario")
    private Horario horario;

    @ManyToOne
    @MapsId("idMedico")
    @JoinColumn(name = "id_medico", referencedColumnName = "id_medico")
    private Medico medico;

    public HorarioMedico() {}

    public HorarioMedico(Horario horario, Medico medico) {
        this.horario = horario;
        this.medico = medico;
        this.id = new HorarioMedicoId(horario.getIdHorario(), medico.getIdMedico());
    }

    // Getters y Setters

    public HorarioMedicoId getId() {
        return id;
    }

    public void setId(HorarioMedicoId id) {
        this.id = id;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}
