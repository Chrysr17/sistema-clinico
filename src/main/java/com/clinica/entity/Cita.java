package com.clinica.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumns;

@Entity
@Table(name = "cita")
public class Cita {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_cita")
	private Integer idCita;
	
	@Column(name = "fecha_cita")
	private LocalDate fechaCita;
	
	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false)
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "id_medico", nullable = false)
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "id_horario", nullable = false)
	private Horario horario;

	@ManyToOne
	@JoinColumn(name = "id_hora", nullable = false)
	private Hora hora;

	public Cita() {
		// TODO Auto-generated constructor stub
	}

	public Cita(LocalDate fechaCita, Integer idCita, Paciente paciente, Horario horario, Hora hora, Medico medico) {
		this.fechaCita = fechaCita;
		this.idCita = idCita;
		this.paciente = paciente;
		this.horario = horario;
		this.hora = hora;
		this.medico = medico;
	}


	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public LocalDate getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDate fechaCita) {
		this.fechaCita = fechaCita;
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

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }
}
