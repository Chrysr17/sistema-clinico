package com.clinica.service;

import java.util.List;

import com.clinica.entity.Especialidad;

public interface EspecialidadService {
	
    List<Especialidad> listarTodas();
    Especialidad buscarPorId(Integer id);
    void guardar(Especialidad especialidad);
    void eliminar(Integer id);

}
