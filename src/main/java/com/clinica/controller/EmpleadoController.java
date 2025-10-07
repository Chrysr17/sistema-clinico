package com.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clinica.entity.Empleado;
import com.clinica.service.EmpleadoService;

@RequestMapping("/empleados")
@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", empleadoService.listarTodos());
        return "empleados"; // Vista empleados.html
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "form-empleado"; // Vista form-empleado.html
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Empleado empleado) {
        empleadoService.guardar(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("empleado", empleadoService.buscarPorId(id));
        return "form-empleado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        empleadoService.eliminar(id);
        return "redirect:/empleados";
    }

}
