package com.clinica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clinica.entity.HistoriaClinica;
import com.clinica.repository.HistoriaRepository;
import com.clinica.service.HistoriaService;

import java.util.Optional;


@Service
public class HistoriaServiceImpl implements HistoriaService{

	@Autowired
	private HistoriaRepository historiaRepository;

	@Override
	public HistoriaClinica registrarHistoria(HistoriaClinica historia) {
		return historiaRepository.save(historia);
	}

	@Override
	public Optional<HistoriaClinica> obtenerPorIdPaciente(Integer idPaciente) {
		return Optional.empty();
	}

	@Override
	public void guardar(HistoriaClinica historia) {
		historiaRepository.save(historia);
	}

	@Override
	public HistoriaClinica obtenerPorPaciente(Integer idPaciente) {
		return historiaRepository.findByPaciente_IdPaciente(idPaciente);
	}

	@Override
	public HistoriaClinica actualizarHistoria(HistoriaClinica historia) {
		return historiaRepository.save(historia);
	}
}

