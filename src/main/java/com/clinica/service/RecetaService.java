package com.clinica.service;

import com.clinica.entity.Receta;

import java.util.List;

public interface RecetaService {
    Receta registrarReceta(Receta receta);
    List<Receta> listarPorPaciente(Integer idPaciente);
}
