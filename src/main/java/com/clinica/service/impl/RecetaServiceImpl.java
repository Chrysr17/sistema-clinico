package com.clinica.service.impl;

import com.clinica.entity.Receta;
import com.clinica.repository.RecetaRepository;
import com.clinica.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaServiceImpl implements RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;

    @Override
    public Receta registrarReceta(Receta receta) {
        return recetaRepository.save(receta);
    }

    @Override
    public List<Receta> listarPorPaciente(Integer idPaciente) {
        return recetaRepository.findByPaciente_IdPaciente(idPaciente);
    }
}
