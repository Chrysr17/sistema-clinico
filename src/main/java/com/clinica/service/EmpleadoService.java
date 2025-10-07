package com.clinica.service;

import java.util.List;

import com.clinica.entity.Empleado;

public interface EmpleadoService {
    List<Empleado> listarTodos();
    Empleado buscarPorId(Integer id);
    void guardar(Empleado empleado);
    void eliminar(Integer id);

}
