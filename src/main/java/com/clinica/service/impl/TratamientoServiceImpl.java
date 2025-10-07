package com.clinica.service.impl;

import com.clinica.entity.Tratamiento;
import com.clinica.repository.TratamietoRepository;
import com.clinica.service.TratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamietoRepository tratamietoRepository;

    @Override
    public Tratamiento guardarTratamiento(Tratamiento tratamiento) {
        return tratamietoRepository.save(tratamiento);
    }

    @Override
    public List<Tratamiento> listarPorDiagnostico(Integer idDiagnostico) {
        return tratamietoRepository.findByDiagnostico_IdDiagnostico(idDiagnostico);
    }
}
