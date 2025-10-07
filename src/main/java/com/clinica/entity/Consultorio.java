package com.clinica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="consultorio")
public class Consultorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consultorio")
	private Integer idConsultorio;
	
	@Column(name = "nombre_consultorio")
	private String nombreConsultorio;
	
	public Consultorio() {
		// TODO Auto-generated constructor stub
	}

	public Consultorio(Integer idConsultorio, String nombreConsultorio) {
		super();
		this.idConsultorio = idConsultorio;
		this.nombreConsultorio = nombreConsultorio;
	}

	public Integer getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(Integer idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public String getNombreConsultorio() {
		return nombreConsultorio;
	}

	public void setNombreConsultorio(String nombreConsultorio) {
		this.nombreConsultorio = nombreConsultorio;
	}

}
