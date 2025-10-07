package com.clinica.service;

import com.clinica.entity.Tratamiento;

import java.util.List;

public interface TratamientoService {
    Tratamiento guardarTratamiento(Tratamiento tratamiento);
    List<Tratamiento> listarPorDiagnostico(Integer idDiagnostico);
}
