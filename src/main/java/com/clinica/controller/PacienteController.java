package com.clinica.controller;

import java.util.List;

import com.clinica.service.EspecialidadService;
import com.clinica.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.clinica.entity.HorarioMedicoHora;
import com.clinica.entity.Paciente;
import com.clinica.service.HorarioMedicoHoraService;
import com.clinica.service.PacienteService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PacienteController {
	
    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private HorarioMedicoHoraService horarioMedicoHoraService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private EspecialidadService especialidadService;
    
    @GetMapping("/inicio")
    public String inicioPaciente(Model modelo, HttpSession session) {
        Integer idUsuario = (Integer) session.getAttribute("idUsuario");
        if (idUsuario != null) {
            Paciente paciente = pacienteService.obtenerPacientePorIdUsuario(idUsuario);
            modelo.addAttribute("paciente", paciente);
        }
        return "paciente/inicio";
    }

    @GetMapping("/horarios-disponibles")
    public String verHorariosDisponibles(@RequestParam(name = "idMedico", required = false) Integer idMedico,
                                         @RequestParam(name = "especialidadId", required = false) Integer especialidadId,
                                         Model model, HttpSession session) {

        Integer idUsuario = (Integer) session.getAttribute("idUsuario");
        if (idUsuario != null) {
            Paciente paciente = pacienteService.obtenerPacientePorIdUsuario(idUsuario);
            model.addAttribute("paciente", paciente);
        }

        // Filtrado combinado de horarios
        List<HorarioMedicoHora> horarios;
        if ((idMedico == null || idMedico == 0) && (especialidadId == null || especialidadId == 0)) {
            horarios = horarioMedicoHoraService.listarTodos();
        } else if (idMedico != null && idMedico != 0 && (especialidadId == null || especialidadId == 0)) {
            horarios = horarioMedicoHoraService.listarPorMedico(idMedico);
        } else if ((idMedico == null || idMedico == 0) && especialidadId != null && especialidadId != 0) {
            horarios = horarioMedicoHoraService.listarPorEspecialidad(especialidadId);
        } else {
            // Ambos filtros aplicados
            horarios = horarioMedicoHoraService.listarPorMedicoYEspecialidad(idMedico, especialidadId);
        }

        // Listas auxiliares para los filtros
        model.addAttribute("medicos", medicoService.listarTodos());
        model.addAttribute("especialidades", especialidadService.listarTodas());

        // Mantener valores seleccionados
        model.addAttribute("idMedicoSeleccionado", idMedico == null ? 0 : idMedico);
        model.addAttribute("especialidadIdSeleccionada", especialidadId == null ? 0 : especialidadId);
        model.addAttribute("horarios", horarios);

        return "/paciente/horarios";
    }

    @GetMapping("/mis-datos")
    public String verFormularioDatos(Model modelo, HttpSession session) {
        Integer idUsuario = (Integer) session.getAttribute("idUsuario");
        if (idUsuario != null) {
            Paciente paciente = pacienteService.obtenerPacientePorIdUsuario(idUsuario);
            modelo.addAttribute("paciente", paciente);
        }
        return "paciente/mis-datos";
    }

    @PostMapping("/actualizar-datos")
    public String actualizarDatos(@ModelAttribute("paciente") Paciente pacienteActualizado, HttpSession session) {
        Integer idUsuario = (Integer) session.getAttribute("idUsuario");
        if (idUsuario != null) {
            Paciente paciente = pacienteService.obtenerPacientePorIdUsuario(idUsuario);

            paciente.setNombres(pacienteActualizado.getNombres());
            paciente.setApellidos(pacienteActualizado.getApellidos());
            paciente.setCorreo(pacienteActualizado.getCorreo());
            paciente.setTelefono(pacienteActualizado.getTelefono());
            paciente.setFechaNacimiento(pacienteActualizado.getFechaNacimiento());

            pacienteService.actualizarPaciente(paciente);
        }
        return "redirect:/mis-datos?exito";
    }

}