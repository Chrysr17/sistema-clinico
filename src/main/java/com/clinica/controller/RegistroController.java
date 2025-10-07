package com.clinica.controller;


import com.clinica.entity.Paciente;
import com.clinica.entity.Usuario;
import com.clinica.service.PacienteService;
import com.clinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        Paciente paciente = new Paciente();
        paciente.setUsuario(new Usuario()); // importante para el binding del campo password
        model.addAttribute("paciente", paciente);
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarPaciente(@ModelAttribute Paciente paciente) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setDni(paciente.getDni());
        nuevoUsuario.setPassword(paciente.getUsuario().getPassword()); // el formulario lo mapea aquí
        nuevoUsuario.setRol("PACIENTE");

        Usuario usuarioGuardado = usuarioService.guardarUsuario(nuevoUsuario);

        paciente.setUsuario(usuarioGuardado);
        pacienteService.guardarPaciente(paciente);

        return "redirect:/login";
    }
}
