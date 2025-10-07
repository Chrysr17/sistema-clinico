package com.clinica.service;

import com.clinica.entity.Paciente;
import com.clinica.entity.Usuario;

import java.util.Optional;

public interface PacienteService {

    Paciente obtenerPacientePorIdUsuario(Integer idUsuario);
    Paciente buscarPorUsuario(Usuario usuario); // Buscar paciente por el usuario logueado
    Paciente actualizarPaciente(Paciente paciente);
    Paciente guardarPaciente(Paciente paciente);
    Paciente obtenerPorId(Integer idPaciente);
}
