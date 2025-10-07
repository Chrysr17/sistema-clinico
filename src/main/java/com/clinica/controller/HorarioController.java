package com.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.entity.Horario;
import com.clinica.service.EmpleadoService;
import com.clinica.service.HorarioService;

@Controller
@RequestMapping("/fechas")
public class HorarioController {
	
	@Autowired
	private HorarioService horarioService;
	
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", horarioService.listarTodos());
        return "fechas-atencion";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("horario", new Horario());
        model.addAttribute("empleados", empleadoService.listarTodos());
        return "form-horario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Horario horario) {
        horarioService.guardar(horario);
        return "redirect:/fechas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("horario", horarioService.buscarPorId(id));
        model.addAttribute("empleados", empleadoService.listarTodos());
        return "form-horario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        horarioService.eliminar(id);
        return "redirect:/fechas";
    }

}
