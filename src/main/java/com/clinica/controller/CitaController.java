package com.clinica.controller;

import java.time.LocalDate;

import com.clinica.entity.*;
import com.clinica.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        @Autowired
        private HoraService horaService;

        @Autowired
        private HorarioService horarioService;

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
			HorarioMedicoHora horarioMedicoHora = horarioMedicoHoraService
					.buscarPorId(idHorario, idMedico, idHora);
			Cita cita = new Cita();
			cita.setFechaCita(LocalDate.now());
			cita.setPaciente(paciente);
            Horario horario = horarioService.buscarPorId(idHorario);
            cita.setHorario(horario);
			Medico medico = medicoService.buscarPorId(idMedico);
			cita.setMedico(medico);
            Hora hora = horaService.buscarPorId(idHora);
            cita.setHora(hora);
			citaService.registrarCita(cita);

			horarioMedicoHoraService.actualizarEstadoHorario(idHorario, idMedico, idHora, "OCUPADO");

			return "redirect:/generar?idHorario=" + idHorario + "&idMedico=" + idMedico + "&idHora=" + idHora;
		}

		return "redirect:/login";
	}
}
