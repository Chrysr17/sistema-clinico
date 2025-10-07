package com.clinica.repository;

import com.clinica.entity.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetaRepository extends JpaRepository<Receta, Integer> {
    List<Receta> findByPaciente_IdPaciente(Integer idPaciente);
    List<Receta> findByMedico_IdMedico(Integer idMedico);
    Receta save(Receta r);
}
