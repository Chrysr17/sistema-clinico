package com.clinica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empleado")
	private Integer idEmpleado;
	
	@Column(name = "nombre_empleado")
	private String nombreEmpleado;
	
	private String cargo;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(Integer idEmpleado, String nombreEmpleado, String cargo) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.cargo = cargo;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
