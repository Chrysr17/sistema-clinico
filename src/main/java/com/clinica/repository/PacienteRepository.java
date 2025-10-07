package com.clinica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.entity.Paciente;
import com.clinica.entity.Usuario;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
	
	Optional<Paciente> findByUsuarioIdUsuario(Integer idUsuario);
	 Optional<Paciente> findByUsuario(Usuario usuario);
	Optional<Paciente> findById(Integer idPaciente);
}
