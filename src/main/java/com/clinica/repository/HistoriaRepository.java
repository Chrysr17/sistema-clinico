package com.clinica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.entity.HistoriaClinica;

public interface HistoriaRepository extends JpaRepository<HistoriaClinica, Integer>{

	Optional<HistoriaClinica> findByPacienteIdPaciente(Integer idPaciente);
	HistoriaClinica findByPaciente_IdPaciente(Integer idPaciente);

}
