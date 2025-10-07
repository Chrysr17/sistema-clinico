package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.entity.Hora;
import com.clinica.repository.HoraRepository;
import com.clinica.service.HoraService;

@Service
public class HoraServiceImpl implements HoraService{
	
	@Autowired
	private HoraRepository horaRepository;

	@Override
	public List<Hora> listarTodas() {
		// TODO Auto-generated method stub
		return horaRepository.findAll();
	}

	@Override
	public Hora buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return horaRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Hora hora) {
		// TODO Auto-generated method stub
		horaRepository.save(hora);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		horaRepository.deleteById(id);
	}
	
}
