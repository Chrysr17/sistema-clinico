package com.clinica.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hora")
public class Hora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hora")
	private Integer id;
	
	@Column(name = "hora_inicio", nullable = false)
	private LocalTime horaInicio;
	
	@Column(name = "hora_fin", nullable = false)
	private LocalTime horaFin;
	
	public Hora() {
		// TODO Auto-generated constructor stub
	}

	public Hora(Integer id, LocalTime horaInicio, LocalTime horaFin) {
		super();
		this.id = id;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

}
