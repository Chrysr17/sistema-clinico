package com.clinica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.entity.HorarioMedico;
import com.clinica.entity.HorarioMedicoId;
import com.clinica.entity.Medico;
import com.clinica.repository.HorarioMedicoRepository;
import com.clinica.service.HorarioMedicoService;

@Service
public class HorarioMedicoServiceImpl implements HorarioMedicoService{
	
	@Autowired
	private HorarioMedicoRepository horarioMedicoRepository;

	@Override
	public List<HorarioMedico> listarTodos() {
		// TODO Auto-generated method stub
		return horarioMedicoRepository.findAll();
	}

	@Override
	public void guardar(HorarioMedico horarioMedico) {
		// TODO Auto-generated method stub
		horarioMedicoRepository.save(horarioMedico);
	}

	@Override
	public void eliminarPorId(HorarioMedicoId id) {
		// TODO Auto-generated method stub
		horarioMedicoRepository.deleteById(id);
	}

	@Override
	public HorarioMedico buscarPorId(HorarioMedicoId id) {
		// TODO Auto-generated method stub
		return horarioMedicoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Medico> listarMedicosUnicos() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
