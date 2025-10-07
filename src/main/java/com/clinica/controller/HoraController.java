package com.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.entity.Hora;
import com.clinica.service.HoraService;

@Controller
@RequestMapping("/horas")
public class HoraController {
	
	@Autowired
	private HoraService horaService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("lista", horaService.listarTodas());
		return "horas";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("hora", new Hora());
		return "form-hora";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Hora hora) {
		horaService.guardar(hora);
		return "redirect:/horas";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		model.addAttribute("hora", horaService.buscarPorId(id));
		return "form-hora";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Integer id) {
		horaService.eliminar(id);
		return "redirect:/horas";
	}
	
}
