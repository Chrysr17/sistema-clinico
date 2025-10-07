package com.clinica.service;

import java.util.List;
import java.util.Optional;

import com.clinica.entity.HorarioMedicoHora;
import com.clinica.entity.HorarioMedicoHoraId;

public interface HorarioMedicoHoraService {

	List<HorarioMedicoHora> listarTodos();
	Optional<HorarioMedicoHora> buscarPorId(HorarioMedicoHoraId id);
	HorarioMedicoHora guardar(HorarioMedicoHora horarioMedicoHora);
	void eliminarPorId(HorarioMedicoHoraId id);
	List<HorarioMedicoHora> listarPorMedico(Integer idMedico);
    HorarioMedicoHora buscarPorId(Integer idHorario, Integer idMedico, Integer idHora);
    void actualizarEstadoHorario(Integer idHorario, Integer idMedico, Integer idHora, String nuevoEstado);
	List<HorarioMedicoHora> listarPorEspecialidad(Integer especialidadId);
	List<HorarioMedicoHora> listarPorMedicoYEspecialidad(Integer idMedico, Integer especialidadId);
}
