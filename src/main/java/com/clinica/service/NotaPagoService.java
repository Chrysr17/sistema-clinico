package com.clinica.service;

import java.util.List;

import com.clinica.entity.HorarioMedicoHora;
import com.clinica.entity.NotaPago;
import com.clinica.entity.Paciente;

public interface NotaPagoService {
    NotaPago generarNotaPago(Paciente paciente, HorarioMedicoHora horario);
    List<NotaPago> listarNotasPorPaciente(Integer idPaciente);
    void registrarNotaPago(NotaPago nota);
    
}
