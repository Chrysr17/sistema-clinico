package com.clinica.entity;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historia", nullable = false)
	private Integer idHistoria;
	
	@Column(name = "fecha_creacion")
	private Timestamp fechaCreacion;
	
	@Column(name = "antecedentes", columnDefinition = "TEXT")
	private String antecedentes;
	
	@Column(name = "alergias", columnDefinition = "TEXT")
	private String alergias;
	
	@Column(name = "otros", columnDefinition = "TEXT")
	private String otros;
	
	@ManyToOne
	@JoinColumn(name = "id_paciente" , unique = true, nullable = false)
	private Paciente paciente;

	public HistoriaClinica() {
		// TODO Auto-generated constructor stub
	}

	public HistoriaClinica(Integer idHistoria, Timestamp fechaCreacion, String antecedentes, String alergias,
			String otros, Paciente paciente) {
		super();
		this.idHistoria = idHistoria;
		this.fechaCreacion = fechaCreacion;
		this.antecedentes = antecedentes;
		this.alergias = alergias;
		this.otros = otros;
		this.paciente = paciente;
	}

	public Integer getIdHistoria() {
		return idHistoria;
	}

	public void setIdHistoria(Integer idHistoria) {
		this.idHistoria = idHistoria;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
