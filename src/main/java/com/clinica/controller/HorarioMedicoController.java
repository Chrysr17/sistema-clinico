package com.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinica.entity.Horario;
import com.clinica.entity.HorarioMedico;
import com.clinica.entity.HorarioMedicoId;
import com.clinica.entity.Medico;
import com.clinica.service.HorarioMedicoService;
import com.clinica.service.HorarioService;
import com.clinica.service.MedicoService;

@Controller
@RequestMapping("/asignaciones")
public class HorarioMedicoController {

	@Autowired
	private HorarioMedicoService horarioMedicoService;

	@Autowired
	private HorarioService horarioService;

	@Autowired
	private MedicoService medicoService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("lista", horarioMedicoService.listarTodos());
		return "asignaciones";
	}

	@GetMapping("/nuevo")
	public String guardar(Model model) {
		model.addAttribute("horarios", horarioService.listarTodos());
		model.addAttribute("medicos", medicoService.listarTodos());
		model.addAttribute("horarioMedico", new HorarioMedico());
		return "form-asignacion";
	}

	@PostMapping("/guardar")
	public String guardar(@RequestParam("idHorario") Integer idHorario, @RequestParam("idMedico") Integer idMedico) {

		Horario horario = horarioService.buscarPorId(idHorario);
		Medico medico = medicoService.buscarPorId(idMedico);

		HorarioMedico horarioMedico = new HorarioMedico(horario, medico);
		horarioMedicoService.guardar(horarioMedico);

		return "redirect:/asignaciones";
	}

	@GetMapping("/editar")
	public String editar(@RequestParam("idHorario") Integer idHorario, @RequestParam("idMedico") Integer idMedico,
			Model model) {

		HorarioMedicoId id = new HorarioMedicoId(idHorario, idMedico);
		HorarioMedico asignacion = horarioMedicoService.buscarPorId(id);

		model.addAttribute("editar", true);
		model.addAttribute("horarioMedico", asignacion);
		model.addAttribute("horarioId", idHorario);
		model.addAttribute("medicoId", idMedico);
		model.addAttribute("horarios", horarioService.listarTodos());
		model.addAttribute("medicos", medicoService.listarTodos());

		return "form-asignacion";
	}

	@PostMapping("/elimniar")
	public String eliminar(@RequestParam("idHorario") Integer idHorario, @RequestParam("idMedico") Integer idMedico) {

		HorarioMedicoId id = new HorarioMedicoId(idHorario, idMedico);
		horarioMedicoService.eliminarPorId(id);
		return "redirect:/asignaciones";

	}

}
