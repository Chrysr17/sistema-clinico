package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.entity.Especialidad;
import com.clinica.repository.EspecialidadRepository;
import com.clinica.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{
	
	@Autowired
	private EspecialidadRepository especialidadRepository;

	@Override
	public List<Especialidad> listarTodas() {
		// TODO Auto-generated method stub
		return especialidadRepository.findAll();
	}

	@Override
	public Especialidad buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return especialidadRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Especialidad especialidad) {
		// TODO Auto-generated method stub
		especialidadRepository.save(especialidad);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		especialidadRepository.deleteById(id);
	}
	

}
