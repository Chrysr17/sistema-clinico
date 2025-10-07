package com.clinica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.entity.Medico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicoRepository extends JpaRepository<Medico, Integer>{
	List<Medico> findByEspecialidadIdEspecialidad(Integer idEspecialidad);
	Medico findByUsuario_IdUsuario(Integer idUsuario);

	@Query("SELECT m FROM Medico m JOIN FETCH m.usuario WHERE m.idMedico = :id")
	Medico fetchMedicoCompleto(@Param("id") Integer id);

	Optional<Medico> findById(Integer idMedico);

}
