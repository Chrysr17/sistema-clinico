package com.clinica.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clinica.entity.Paciente;
import com.clinica.entity.Usuario;
import com.clinica.repository.PacienteRepository;
import com.clinica.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public Paciente obtenerPacientePorIdUsuario(Integer idUsuario) {
		return pacienteRepository.findByUsuarioIdUsuario(idUsuario).orElse(null);
	}

	@Override
	public Paciente actualizarPaciente(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	@Override
	public Paciente guardarPaciente(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	@Override
	public Paciente obtenerPorId(Integer idPaciente) {
		return pacienteRepository.findById(idPaciente).orElse(null);
	}

	@Override
	public Paciente buscarPorUsuario(Usuario usuario) {
        return pacienteRepository.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado para el usuario."));
	}

}
