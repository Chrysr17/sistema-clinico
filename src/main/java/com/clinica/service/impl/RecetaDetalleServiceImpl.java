package com.clinica.service.impl;

import com.clinica.entity.RecetaDetalle;
import com.clinica.repository.RecetaDetalleRespository;
import com.clinica.service.RecetaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaDetalleServiceImpl implements RecetaDetalleService {

    @Autowired
    private RecetaDetalleRespository recetaDetalleRespository;

    @Override
    public void guardarDetalle(RecetaDetalle detalle) {
        recetaDetalleRespository.save(detalle);
    }

    @Override
    public List<RecetaDetalle> listarPorReceta(Integer idReceta) {
        return recetaDetalleRespository.findByReceta_IdReceta(idReceta);
    }
}
