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

@Entity
@Table(name = "horario")
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_horario")
	private Integer idHorario;
	
	@Column(name = "fecha_horario")
	private LocalDate fechaHorario;
	
	@ManyToOne
	@JoinColumn(name = "id_empleado", nullable = false)
	private Empleado empleado;
	
	public Horario() {
		// TODO Auto-generated constructor stub
	}

	public Horario(Integer idHorario, LocalDate fechaHorario, Empleado empleado) {
		super();
		this.idHorario = idHorario;
		this.fechaHorario = fechaHorario;
		this.empleado = empleado;
	}

	public Integer getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	public LocalDate getFechaHorario() {
		return fechaHorario;
	}

	public void setFechaHorario(LocalDate fechaHorario) {
		this.fechaHorario = fechaHorario;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	

}
