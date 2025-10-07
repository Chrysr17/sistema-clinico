package com.clinica.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "especialidad")
public class Especialidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_especialidad")
	private Integer idEspecialidad;
	
	@Column(name = "nombre_especialidad", nullable = false)
	private String nombreEspecialidad;
	
	@Column(name = "precio", nullable = false)
	private BigDecimal precio;
	
	public Especialidad() {
		// TODO Auto-generated constructor stub
	}

	public Especialidad(Integer idEspecialidad, String nombreEspecialidad, BigDecimal precio) {
		super();
		this.idEspecialidad = idEspecialidad;
		this.nombreEspecialidad = nombreEspecialidad;
		this.precio = precio;
	}

	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}	

}
