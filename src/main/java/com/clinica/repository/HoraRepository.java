package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.entity.Hora;

public interface HoraRepository extends JpaRepository<Hora, Integer>{
	
}
