package com.clinica.repository;

import com.clinica.entity.RecetaAnalisis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetaAnalisisRepository extends JpaRepository<RecetaAnalisis, Integer> {
    List<RecetaAnalisis> findByReceta_IdReceta(Integer idReceta);
}
