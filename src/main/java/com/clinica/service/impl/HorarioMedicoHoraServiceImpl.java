package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.clinica.entity.HorarioMedicoHora;
import com.clinica.entity.HorarioMedicoHoraId;
import com.clinica.repository.HorarioMedicoHoraRepository;
import com.clinica.service.HorarioMedicoHoraService;

@Service
public class HorarioMedicoHoraServiceImpl implements HorarioMedicoHoraService{
	
	@Autowired
	private HorarioMedicoHoraRepository repository;


    @PostConstruct
    public void verificarDatos() {
        List<HorarioMedicoHora> lista = listarTodos();
    }
    @Override
    @Transactional(readOnly = true)
    public List<HorarioMedicoHora> listarTodos() {
        return repository.listarTodosConRelaciones();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<HorarioMedicoHora> buscarPorId(HorarioMedicoHoraId id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public HorarioMedicoHora guardar(HorarioMedicoHora horarioMedicoHora) {
        return repository.save(horarioMedicoHora);
    }

    @Override
    @Transactional
    public void eliminarPorId(HorarioMedicoHoraId id) {
        repository.deleteById(id);
    }

	@Override
	public List<HorarioMedicoHora> listarPorMedico(Integer idMedico) {
		// TODO Auto-generated method stub
		return repository.findByHorarioMedicoMedicoIdMedico(idMedico);
	}

	@Override
	public HorarioMedicoHora buscarPorId(Integer idHorario, Integer idMedico, Integer idHora) {
        return repository.buscarConDetalles(idHorario, idMedico, idHora);
	}

	@Override
	public void actualizarEstadoHorario(Integer idHorario, Integer idMedico, Integer idHora, String nuevoEstado) {
		// TODO Auto-generated method stub	
		
        HorarioMedicoHoraId id = new HorarioMedicoHoraId(idHorario, idMedico, idHora);
        Optional<HorarioMedicoHora> optional = repository.findById(id);
        if (optional.isPresent()) {
            HorarioMedicoHora horario = optional.get();
            horario.setEstado(nuevoEstado);
            repository.save(horario);
        }
	}

    @Override
    public List<HorarioMedicoHora> listarPorEspecialidad(Integer especialidadId) {
        return repository.listarPorEspecialidad(especialidadId);
    }

    @Override
    public List<HorarioMedicoHora> listarPorMedicoYEspecialidad(Integer idMedico, Integer especialidadId) {
        return repository.listarPorMedicoYEspecialidad(idMedico, especialidadId);
    }

}
