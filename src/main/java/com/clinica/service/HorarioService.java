package com.clinica.service;

import java.util.List;

import com.clinica.entity.Horario;

public interface HorarioService{

    List<Horario> listarTodos();
    Horario buscarPorId(Integer id);
    void guardar(Horario horario);
    void eliminar(Integer id);
}
