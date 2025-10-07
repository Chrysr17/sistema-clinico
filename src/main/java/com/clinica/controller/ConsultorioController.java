package com.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.entity.Consultorio;
import com.clinica.service.ConsultorioService;

@Controller
@RequestMapping("/consultorios")
public class ConsultorioController {
	
	@Autowired
	private ConsultorioService consultorioService;
	
	@GetMapping
	public String Listar(Model model){
		model.addAttribute("lista", consultorioService.listarTodos());
		return "consultorios";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("consultorio", new Consultorio());
		return "form-consultorio";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Consultorio consultorio) {
		consultorioService.guardar(consultorio);
		return "redirect:/consultorios";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		model.addAttribute("consultorio", consultorioService.buscarPorId(id));
		return "form-consultorio";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Integer id) {  
		consultorioService.eliminar(id);
		return "redirect:/consultorios";
	}

}
