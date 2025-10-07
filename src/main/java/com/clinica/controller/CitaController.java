package com.clinica.controller;

import java.time.LocalDate;

import com.clinica.entity.*;
import com.clinica.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinica.service.CitaService;
import com.clinica.service.HorarioMedicoHoraService;
import com.clinica.service.PacienteService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CitaController {

	   @Autowired
	    private CitaService citaService;

	    @Autowired
	    private HorarioMedicoHoraService horarioMedicoHoraService;

	    @Autowired
	    private PacienteService pacienteService;

		@Autowired
		private MedicoService medicoService;

	    @GetMapping("/registrar/{idHorario}/{idMedico}/{idHora}")
	    public String mostrarFormularioCita(@PathVariable("idHorario") Integer idHorario,
	                                        @PathVariable("idMedico") Integer idMedico,
	                                        @PathVariable("idHora") Integer idHora,
	                                        Model modelo,
	                                        HttpSession session) {
	        HorarioMedicoHora horarioSeleccionado = horarioMedicoHoraService
	                .buscarPorId(idHorario, idMedico, idHora);

			Cita cita = new Cita();
			cita.setMedico(horarioSeleccionado.getHorarioMedico().getMedico());
			cita.setHorario(horarioSeleccionado.getHorarioMedico().getHorario());
			cita.setHora(horarioSeleccionado.getHora());

	        modelo.addAttribute("horarioSeleccionado", horarioSeleccionado);
	        modelo.addAttribute("cita", cita);

	        return "cita/formulario-cita";
	    }

	@PostMapping("/guardarCita")
	public String guardarCita(
							  @RequestParam("idHorario") Integer idHorario,
							  @RequestParam("idMedico") Integer idMedico,
							  @RequestParam("idHora") Integer idHora,
							  HttpSession session) {

		Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

		if (usuario != null) {
			Paciente paciente = pacienteService.buscarPorUsuario(usuario);
			HorarioMedicoHora horario = horarioMedicoHoraService
					.buscarPorId(idHorario, idMedico, idHora);
			Cita cita = new Cita();
			cita.setFechaCita(LocalDate.now());
			cita.setPaciente(paciente);
			Medico medico = medicoService.buscarPorId(idMedico);
			cita.setMedico(medico);

			citaService.registrarCita(cita);

			horarioMedicoHoraService.actualizarEstadoHorario(idHorario, idMedico, idHora, "OCUPADO");

			return "redirect:/generar?idHorario=" + idHorario + "&idMedico=" + idMedico + "&idHora=" + idHora;
		}

		return "redirect:/login";
	}
}
