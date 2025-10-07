package com.clinica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.entity.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer>{
	List<Cita> findByPacienteIdPaciente(Integer idPaciente);
	List<Cita> findByMedico_IdMedico(Integer idMedico);

	Optional<Cita> findById(Integer idCita);
}
