package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.entity.HorarioMedico;
import com.clinica.entity.HorarioMedicoId;

public interface HorarioMedicoRepository extends JpaRepository<HorarioMedico, HorarioMedicoId>{

}
