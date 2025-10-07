package com.clinica.service;

import com.clinica.entity.RecetaDetalle;

import java.util.List;

public interface RecetaDetalleService {
    void guardarDetalle(RecetaDetalle detalle);
    List<RecetaDetalle> listarPorReceta(Integer idReceta);
}
