package com.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinica.entity.Medico;
import com.clinica.service.EspecialidadService;
import com.clinica.service.MedicoService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	@Autowired
	private EspecialidadService especialidadService;

	@GetMapping
	public String listar(@RequestParam(name = "especialidadId", required = false, defaultValue = "0") Integer especialidadId, Model model) {

		List<Medico> medicos;

		if (especialidadId != null && especialidadId != 0) {
			medicos = medicoService.listarPorEspecialidad(especialidadId);
		} else {
			medicos = medicoService.listarTodos();
		}

		model.addAttribute("lista", medicos);
		model.addAttribute("especialidades", especialidadService.listarTodas());
		model.addAttribute("especialidadId", especialidadId);

		return "medicos";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("medico", new Medico());
		model.addAttribute("especialidades", especialidadService.listarTodas());
		return "form-medico";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Medico medico) {
		medicoService.guardar(medico);
		return "redirect:/medicos";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		model.addAttribute("medico", medicoService.buscarPorId(id));
		model.addAttribute("especialidades", especialidadService.listarTodas());
		return "form-medico";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Integer id) {
		medicoService.eliminar(id);
		return "redirect:/medicos";
	}

}
