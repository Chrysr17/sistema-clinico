package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.entity.Horario;
import com.clinica.repository.HorarioRepository;
import com.clinica.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService{
	
	@Autowired
	private HorarioRepository horarioRepository;

	@Override
	public List<Horario> listarTodos() {
		// TODO Auto-generated method stub
		return horarioRepository.findAll();
	}

	@Override
	public Horario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return horarioRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Horario horario) {
		// TODO Auto-generated method stub
		horarioRepository.save(horario);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		horarioRepository.deleteById(id);
	}

}
