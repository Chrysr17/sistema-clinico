package com.clinica.service.impl;

import com.clinica.entity.Analisis;
import com.clinica.repository.AnalisisRepository;
import com.clinica.service.AnalisisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalsisServiceImpl implements AnalisisService {

    @Autowired
    private AnalisisRepository analisisRepository;

    @Override
    public List<Analisis> listarTodos() {
        return analisisRepository.findAll();
    }
}
