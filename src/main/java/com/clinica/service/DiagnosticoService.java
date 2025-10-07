package com.clinica.service;

import com.clinica.entity.Diagnostico;

import java.util.List;

public interface DiagnosticoService {
    Diagnostico registrarDiagnostico(Diagnostico diagnostico);
    List<Diagnostico> obtenerPorPaciente(Integer idPaciente);
}
