package com.clinica.service;

import java.util.List;

import com.clinica.entity.HorarioMedico;
import com.clinica.entity.HorarioMedicoId;
import com.clinica.entity.Medico;

public interface HorarioMedicoService{
    List<HorarioMedico> listarTodos();
    HorarioMedico buscarPorId(HorarioMedicoId id);
    void guardar(HorarioMedico horarioMedico);
    void eliminarPorId(HorarioMedicoId id);
    List<Medico> listarMedicosUnicos();
}
