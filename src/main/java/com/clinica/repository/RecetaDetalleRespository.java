package com.clinica.repository;

import com.clinica.entity.RecetaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetaDetalleRespository extends JpaRepository<RecetaDetalle, Integer> {
    List<RecetaDetalle> findByReceta_IdReceta(Integer idReceta);
}
