package com.clinica.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinica.entity.Especialidad;
import com.clinica.entity.HorarioMedicoHora;
import com.clinica.entity.NotaPago;
import com.clinica.entity.Paciente;
import com.clinica.entity.Usuario;
import com.clinica.service.HorarioMedicoHoraService;
import com.clinica.service.NotaPagoService;
import com.clinica.service.PacienteService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NotaPagoController {
	
    @Autowired
    private NotaPagoService notaPagoService;

    @Autowired
    private HorarioMedicoHoraService horarioMedicoHoraService;

    @Autowired
    private PacienteService pacienteService;
    
    @GetMapping("/generar")
    public String mostrarFormularioNotaPago(@RequestParam("idHorario") Integer idHorario,
                                            @RequestParam("idMedico") Integer idMedico,
                                            @RequestParam("idHora") Integer idHora,
                                            Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null || !"PACIENTE".equals(usuario.getRol())) {
            return "redirect:/login";
        }

        Paciente paciente = pacienteService.buscarPorUsuario(usuario);
        HorarioMedicoHora horario = horarioMedicoHoraService.buscarPorId(idHorario, idMedico, idHora);

        // Obtener el precio desde la especialidad del médico
        Especialidad especialidad = horario.getHorarioMedico().getMedico().getEspecialidad();
        BigDecimal precio = especialidad.getPrecio();

        NotaPago nota = new NotaPago();
        nota.setPaciente(paciente);
        nota.setHorarioMedicoHora(horario);
        nota.setMonto(precio);

        model.addAttribute("nota", nota);
        return "paciente/formulario_nota_pago";
    }

    @PostMapping("/guardar")
    public String guardarNotaPago(@ModelAttribute("nota") NotaPago nota, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null || !"PACIENTE".equals(usuario.getRol())) {
            return "redirect:/login";
        }

        nota.setFechaPago(LocalDateTime.now());

        notaPagoService.registrarNotaPago(nota);

        HorarioMedicoHora horario = nota.getHorarioMedicoHora();
        horarioMedicoHoraService.actualizarEstadoHorario(
                horario.getId().getIdHorario(),
                horario.getId().getIdMedico(),
                horario.getId().getIdHora(),
                "RESERVADO"
        );

        return "redirect:/mis-pagos";
    }

    @GetMapping("/mis-pagos")
    public String verMisNotasPago(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario == null || !"PACIENTE".equals(usuario.getRol())) {
            return "redirect:/login";
        }

        Paciente paciente = pacienteService.buscarPorUsuario(usuario);
        List<NotaPago> listaNotas = notaPagoService.listarNotasPorPaciente(paciente.getIdPaciente());

        model.addAttribute("notas", listaNotas);
        return "paciente/lista_notas_pago";
    }

}
