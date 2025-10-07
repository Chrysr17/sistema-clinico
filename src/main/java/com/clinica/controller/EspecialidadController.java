package com.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.entity.Especialidad;
import com.clinica.service.EspecialidadService;

@Controller
@RequestMapping("/especialidades")
public class EspecialidadController {
	
	@Autowired
	private EspecialidadService especialidadService;
	
	@GetMapping
	public String listarEspecialidad(Model model) {
		model.addAttribute("especialidades", especialidadService.listarTodas());
		return "especialidades";
	}
	
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("especialidad", new Especialidad());
        return "form-especialidad"; // Debes crear este HTML para registrar
    }

    @PostMapping("/guardar")
    public String guardarEspecialidad(@ModelAttribute Especialidad especialidad) {
        especialidadService.guardar(especialidad);
        return "redirect:/especialidades";
    }

    @GetMapping("/editar/{id}")
    public String editarEspecialidad(@PathVariable Integer id, Model model) {
        model.addAttribute("especialidad", especialidadService.buscarPorId(id));
        return "form-especialidad"; // Mismo formulario, pero precargado
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEspecialidad(@PathVariable Integer id) {
        especialidadService.eliminar(id);
        return "redirect:/especialidades";
    }	

}
