package com.clinica.service;

import java.util.Optional;

import com.clinica.entity.HistoriaClinica;

public interface HistoriaService {
    HistoriaClinica registrarHistoria(HistoriaClinica historia);
    Optional<HistoriaClinica> obtenerPorIdPaciente(Integer idPaciente);
    void guardar(HistoriaClinica historia);;
    HistoriaClinica obtenerPorPaciente(Integer idPaciente);
    HistoriaClinica actualizarHistoria(HistoriaClinica historia);

}
