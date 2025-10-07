package com.clinica.service.impl;

import com.clinica.entity.RecetaAnalisis;
import com.clinica.repository.RecetaAnalisisRepository;
import com.clinica.service.RecetaAnalisisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaAnalisisServiceImpl implements RecetaAnalisisService {

    @Autowired
    private RecetaAnalisisRepository recetaAnalisisRepository;

    @Override
    public void guardar(RecetaAnalisis recetaAnalisis) {
        recetaAnalisisRepository.save(recetaAnalisis);
    }

    @Override
    public List<RecetaAnalisis> listarPorReceta(Integer idReceta) {
        return recetaAnalisisRepository.findByReceta_IdReceta(idReceta);
    }
}
