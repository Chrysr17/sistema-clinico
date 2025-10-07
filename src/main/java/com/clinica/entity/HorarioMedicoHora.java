package com.clinica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario_medico_hora")
public class HorarioMedicoHora {

    @EmbeddedId
    private HorarioMedicoHoraId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "id_horario", referencedColumnName = "id_horario", insertable = false, updatable = false),
        @JoinColumn(name = "id_medico", referencedColumnName = "id_medico", insertable = false, updatable = false)
    })
    private HorarioMedico horarioMedico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hora", insertable = false, updatable = false)
    private Hora hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consultorio", nullable = false)
    private Consultorio consultorio;

    @Column(name = "estado", length = 20)
    private String estado;

    // Constructores
    public HorarioMedicoHora() {}

    public HorarioMedicoHora(HorarioMedicoHoraId id, Consultorio consultorio, String estado) {
        this.id = id;
        this.consultorio = consultorio;
        this.estado = estado;
    }

    // Getters y Setters
    public HorarioMedicoHoraId getId() {
        return id;
    }

    public void setId(HorarioMedicoHoraId id) {
        this.id = id;
    }

    public HorarioMedico getHorarioMedico() {
        return horarioMedico;
    }

    public void setHorarioMedico(HorarioMedico horarioMedico) {
        this.horarioMedico = horarioMedico;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
