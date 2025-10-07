package com.clinica.service.impl;


import com.clinica.entity.Medicamento;
import com.clinica.repository.MedicamentoRepository;
import com.clinica.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Override
    public List<Medicamento> listarTodos() {
        return medicamentoRepository.findAll();
    }
}
