package com.clinica.service.impl;

import java.util.List;

import com.clinica.entity.Usuario;
import com.clinica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.entity.Medico;
import com.clinica.repository.MedicoRepository;
import com.clinica.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService{
	
	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Medico> listarTodos() {
		return medicoRepository.findAll();
	}

	@Override
	public Medico buscarPorId(Integer id) {
		return medicoRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Medico medico) {
		medicoRepository.save(medico);
	}

	@Override
	public void eliminar(Integer id) {
		medicoRepository.existsById(id);
	}

	@Override
	public List<Medico> listarPorEspecialidad(Integer especialidadId) {
		return medicoRepository.findByEspecialidadIdEspecialidad(especialidadId);
	}

	@Override
	public Medico buscarPorUsuario(Integer idUsuario) {
		return medicoRepository.findByUsuario_IdUsuario(idUsuario);
	}
}
