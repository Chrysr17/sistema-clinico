package com.clinica.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.clinica.entity.HistoriaClinica;
import com.clinica.repository.HistoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.entity.Cita;
import com.clinica.repository.CitaRepository;
import com.clinica.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService{
	
	@Autowired
	private CitaRepository citaRepository;

	@Autowired
	private HistoriaRepository historiaRepository;

	@Override
	public Cita registrarCita(Cita cita) {

		System.out.println(">>> Registrando cita:");
		System.out.println("Paciente: " + (cita.getPaciente() != null ? cita.getPaciente().getIdPaciente() : "null"));
		System.out.println("Médico: " + (cita.getMedico() != null ? cita.getMedico().getIdMedico() : "null"));
		System.out.println("Horario: " + (cita.getHorario() != null ? cita.getHorario().getIdHorario() : "null"));
		System.out.println("Hora: " + (cita.getHora() != null ? cita.getHora().getId() : "null"));


		Cita citaGuardada = citaRepository.save(cita);

		System.out.println(">>> Cita guardada con ID: " + citaGuardada.getIdCita());

		Optional<HistoriaClinica> historiaOpt = historiaRepository.findByPacienteIdPaciente(cita.getPaciente().getIdPaciente());

		if (historiaOpt.isEmpty()) {
			HistoriaClinica historia = new HistoriaClinica();
			historia.setPaciente(cita.getPaciente());
			historia.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
			historia.setAntecedentes("");
			historia.setAlergias("");
			historia.setOtros("");
			historiaRepository.save(historia);
		}

		return citaGuardada;
	}

	@Override
	public List<Cita> obtenerCitasPorPaciente(Integer idPaciente) {
		return citaRepository.findByPacienteIdPaciente(idPaciente);
	}

	@Override
	public List<Cita> obtenerCitasPorMedico(Integer idMedico) {
		return citaRepository.findByMedico_IdMedico(idMedico);
	}

	@Override
	public Cita obtenerPorId(Integer idCita) {
		return citaRepository.findById(idCita).orElse(null);
	}


}
