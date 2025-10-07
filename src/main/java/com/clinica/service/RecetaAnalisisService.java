package com.clinica.service;

import com.clinica.entity.RecetaAnalisis;

import java.util.List;

public interface RecetaAnalisisService {
    void guardar(RecetaAnalisis recetaAnalisis);
    List<RecetaAnalisis> listarPorReceta(Integer idReceta);
}
