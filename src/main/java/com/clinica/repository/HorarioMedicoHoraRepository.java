package com.clinica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinica.entity.HorarioMedicoHora;
import com.clinica.entity.HorarioMedicoHoraId;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioMedicoHoraRepository extends JpaRepository<HorarioMedicoHora, HorarioMedicoHoraId> {

	List<HorarioMedicoHora> findByHorarioMedicoMedicoIdMedico(Integer idMedico);

	@Query("SELECT h FROM HorarioMedicoHora h " +
			"JOIN FETCH h.horarioMedico hm " +
			"JOIN FETCH hm.horario ho " +
			"JOIN FETCH hm.medico m " +
			"JOIN FETCH h.hora hr " +
			"JOIN FETCH h.consultorio c " +
			"WHERE h.estado = 'Activo'")
	List<HorarioMedicoHora> listarTodosConRelaciones();

	@Query("SELECT h FROM HorarioMedicoHora h WHERE h.horarioMedico.medico.especialidad.idEspecialidad = :especialidadId")
	List<HorarioMedicoHora> listarPorEspecialidad(@Param("especialidadId") Integer especialidadId);

	@Query("""
			    SELECT h FROM HorarioMedicoHora h
			    JOIN FETCH h.horarioMedico hm
			    JOIN FETCH hm.horario ho
			    JOIN FETCH hm.medico m
			    JOIN FETCH m.especialidad
			    WHERE h.id.idHorario = :idHorario AND h.id.idMedico = :idMedico AND h.id.idHora = :idHora
			""")
	HorarioMedicoHora buscarConDetalles(@Param("idHorario") Integer idHorario,
										@Param("idMedico") Integer idMedico,
										@Param("idHora") Integer idHora);

	@Query("SELECT h FROM HorarioMedicoHora h WHERE h.horarioMedico.medico.id = :idMedico AND h.horarioMedico.medico.especialidad.id = :especialidadId")
	List<HorarioMedicoHora> listarPorMedicoYEspecialidad(@Param("idMedico") Integer idMedico, @Param("especialidadId") Integer especialidadId);

	@Query("SELECT h FROM HorarioMedicoHora h WHERE h.id.idHorario = :idHorario AND h.id.idMedico = :idMedico AND h.id.idHora = :idHora")
	Optional<HorarioMedicoHora> buscarPorId(@Param("idHorario") Integer idHorario,
											@Param("idMedico") Integer idMedico,
											@Param("idHora") Integer idHora);


}
