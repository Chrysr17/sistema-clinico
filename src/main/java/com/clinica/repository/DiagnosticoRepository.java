package com.clinica.repository;

import com.clinica.entity.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {
    Diagnostico save(Diagnostico d);
    List<Diagnostico> findByPaciente_IdPaciente(Integer idPaciente);
}
