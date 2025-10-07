package com.clinica.service;

import java.util.List;

import com.clinica.entity.Cita;

public interface CitaService {
	Cita registrarCita(Cita cita);
	List<Cita> obtenerCitasPorPaciente(Integer idPaciente);
	List<Cita> obtenerCitasPorMedico(Integer idMedico);
	Cita obtenerPorId(Integer idCita);
}
