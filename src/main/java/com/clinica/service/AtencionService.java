package com.clinica.service;

import com.clinica.entity.Atencion;

import java.util.List;

public interface AtencionService {
    Atencion guardarAtencion(Atencion atencion);
    List<Atencion> listarAtenciones();
    List<Atencion> listarPorCita(Integer idCita);

    Atencion obtenerPorId(Integer idAtencion);

    List<Atencion> listarPorMedico(Integer idMedico);
}
