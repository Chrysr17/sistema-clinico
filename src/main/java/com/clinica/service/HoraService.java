package com.clinica.service;

import java.util.List;
import com.clinica.entity.Hora;


public interface HoraService{
	
    List<Hora> listarTodas();
    Hora buscarPorId(Integer id);
    void guardar(Hora hora);
    void eliminar(Integer id);

}
