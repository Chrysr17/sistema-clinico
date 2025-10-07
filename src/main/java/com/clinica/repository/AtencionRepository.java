package com.clinica.repository;

import com.clinica.entity.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtencionRepository extends JpaRepository<Atencion, Integer> {
    List<Atencion> findByCita_Paciente_IdPaciente(Integer idPaciente);
    List<Atencion> findByCitaMedicoIdMedico(Integer idMedico);
}
