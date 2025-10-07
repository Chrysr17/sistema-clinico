package com.clinica.service.impl;

import com.clinica.entity.Atencion;
import com.clinica.repository.AtencionRepository;
import com.clinica.repository.MedicoRepository;
import com.clinica.service.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtencionServiceImpl implements AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;

    @Override
    public Atencion guardarAtencion(Atencion atencion) {
        return atencionRepository.save(atencion);
    }

    @Override
    public List<Atencion> listarAtenciones() {
        return atencionRepository.findAll();
    }

    @Override
    public List<Atencion> listarPorCita(Integer idCita) {
        return atencionRepository.findByCita_Paciente_IdPaciente(idCita);
    }


    @Override
    public Atencion obtenerPorId(Integer idAtencion) {
        return atencionRepository.findById(idAtencion).orElse(null);
    }

    @Override
    public List<Atencion> listarPorMedico(Integer idMedico) {
        return atencionRepository.findByCitaMedicoIdMedico(idMedico);
    }

}
