package com.clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medico")
	private Integer idMedico;
	
	@Column(name = "nombre_medico")
	private String nombreMedico;
	
	@ManyToOne
	@JoinColumn(name = "id_especialidad")
	private Especialidad especialidad;
	
	private String estado;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")  // FK hacia la tabla usuario
	private Usuario usuario;
	
	public Medico() {
		// TODO Auto-generated constructor stub
	}

	public Medico(Integer idMedico, String nombreMedico, Especialidad especialidad, String estado) {
		super();
		this.idMedico = idMedico;
		this.nombreMedico = nombreMedico;
		this.especialidad = especialidad;
		this.estado = estado;
	}

	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Medico{" +
				"idMedico=" + idMedico +
				", nombre='" + nombreMedico + '\'' +
				", especialidad=" + (especialidad != null ? especialidad.getNombreEspecialidad() : "null") +
				", usuario=" + (usuario != null ? usuario.getNombreUsuario() : "null") +
				'}';
	}
}
