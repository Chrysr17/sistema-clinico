package com.clinica.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paciente")
	private Integer idPaciente;
	
	@Column(name = "dni", nullable = false, unique = true, length = 8)
	private String dni;
	
	@Column(name = "nombres", nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	
	@Column(name = "correo", nullable = false)
	private String correo;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@OneToOne
	@JoinColumn(name = "id_usuario", unique = true)
	private Usuario usuario;
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}
	
	public Paciente(Integer idPaciente, String dni, String nombres, String apellidos, String correo, String telefono,
			LocalDate fechaNacimiento, Usuario usuario) {
		super();
		this.idPaciente = idPaciente;
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.usuario = usuario;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
