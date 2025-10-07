package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.entity.Empleado;
import com.clinica.repository.EmpleadoRepository;
import com.clinica.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> listarTodos() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Empleado empleado) {
		// TODO Auto-generated method stub
		empleadoRepository.save(empleado);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		empleadoRepository.deleteById(id);
	}

}
