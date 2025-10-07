package com.clinica.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.entity.HorarioMedicoHora;
import com.clinica.entity.NotaPago;
import com.clinica.entity.Paciente;
import com.clinica.repository.NotaPagoRepository;
import com.clinica.service.NotaPagoService;


@Service
public class NotaPagoServiceImpl implements NotaPagoService{
	
    @Autowired
    private NotaPagoRepository notaPagoRepo;

    @Override
    public NotaPago generarNotaPago(Paciente paciente, HorarioMedicoHora horario) {
        BigDecimal monto = horario.getHorarioMedico()
                                  .getMedico()
                                  .getEspecialidad()
                                  .getPrecio();

        NotaPago nota = new NotaPago();
        nota.setPaciente(paciente);
        nota.setHorarioMedicoHora(horario); // relación completa
        nota.setMonto(monto);

        return notaPagoRepo.save(nota);
    }

    @Override
    public List<NotaPago> listarNotasPorPaciente(Integer idPaciente) {
        return notaPagoRepo.findByPacienteIdPaciente(idPaciente);
    }

	@Override
	public void registrarNotaPago(NotaPago nota) {
		// TODO Auto-generated method stub
		notaPagoRepo.save(nota);
	}


}
