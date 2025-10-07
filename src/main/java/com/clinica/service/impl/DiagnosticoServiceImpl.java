package com.clinica.service.impl;

import com.clinica.entity.Diagnostico;
import com.clinica.repository.DiagnosticoRepository;
import com.clinica.service.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Override
    public Diagnostico registrarDiagnostico(Diagnostico diagnostico) {
        diagnostico.setFecha(Timestamp.valueOf(LocalDateTime.now()));
        return diagnosticoRepository.save(diagnostico);
    }

    @Override
    public List<Diagnostico> obtenerPorPaciente(Integer idPaciente) {
        return diagnosticoRepository.findByPaciente_IdPaciente(idPaciente);
    }

}
