package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.entity.Consultorio;
import com.clinica.repository.ConsultorioRepositrory;
import com.clinica.service.ConsultorioService;

@Service
public class ConsultorioServiceImpl implements ConsultorioService{
	
	@Autowired
	private ConsultorioRepositrory consultorioRepositrory;

	@Override
	public List<Consultorio> listarTodos() {
		// TODO Auto-generated method stub
		return consultorioRepositrory.findAll();
	}

	@Override
	public Consultorio buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return consultorioRepositrory.findById(id).orElse(null);
	}

	@Override
	public void guardar(Consultorio consultorio) {
		// TODO Auto-generated method stub
		consultorioRepositrory.save(consultorio);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		consultorioRepositrory.deleteById(id);
	}

}
