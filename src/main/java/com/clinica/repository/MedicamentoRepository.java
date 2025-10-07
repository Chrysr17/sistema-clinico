package com.clinica.repository;

import com.clinica.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {
}
