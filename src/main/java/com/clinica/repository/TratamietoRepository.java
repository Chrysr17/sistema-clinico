package com.clinica.repository;

import com.clinica.entity.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TratamietoRepository extends JpaRepository<Tratamiento, Integer> {
    List<Tratamiento> findByDiagnostico_IdDiagnostico(Integer idDiagnostico);
    Tratamiento save(Tratamiento t);
}
