package com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

}
