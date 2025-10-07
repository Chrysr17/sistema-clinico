package com.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.entity.NotaPago;

public interface NotaPagoRepository extends JpaRepository<NotaPago, Integer>{
	
	List<NotaPago> findByPacienteIdPaciente(Integer idPaciente);

}
