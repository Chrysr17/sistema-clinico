package com.clinica.service;

import java.util.List;
import com.clinica.entity.Medico;
import com.clinica.entity.Usuario;

public interface MedicoService {
	
    List<Medico> listarTodos();
    Medico buscarPorId(Integer id);
    void guardar(Medico medico);
    void eliminar(Integer id);
	List<Medico> listarPorEspecialidad(Integer especialidadId);
    Medico buscarPorUsuario(Integer idUsuario);

}
