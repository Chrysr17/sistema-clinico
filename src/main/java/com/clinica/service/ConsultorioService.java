package com.clinica.service;

import java.util.List;

import com.clinica.entity.Consultorio;

public interface ConsultorioService {

    List<Consultorio> listarTodos();
    Consultorio buscarPorId(Integer id);
    void guardar(Consultorio consultorio);
    void eliminar(Integer id);

}
