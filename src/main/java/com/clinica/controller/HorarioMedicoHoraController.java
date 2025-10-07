package com.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinica.entity.Consultorio;
import com.clinica.entity.HorarioMedicoHora;
import com.clinica.entity.HorarioMedicoHoraId;
import com.clinica.service.ConsultorioService;
import com.clinica.service.HoraService;
import com.clinica.service.HorarioMedicoHoraService;
import com.clinica.service.HorarioMedicoService;
import com.clinica.service.MedicoService;

	@Controller
	@RequestMapping("/atenciones")
	public class HorarioMedicoHoraController {
	
		@Autowired
	    private HorarioMedicoHoraService horarioMedicoHoraService;
		@Autowired
	    private ConsultorioService consultorioService;
		@Autowired
		private HorarioMedicoService horarioMedicoService;
		@Autowired
	    private HoraService horaService;
		@Autowired
		private MedicoService medicoService;
		
		
	    // Listar atenciones
		@GetMapping
	    public String listarAtenciones(@RequestParam(name = "idMedico", required = false) Integer idMedico, Model model) {
	        List<HorarioMedicoHora> atenciones;

	        if (idMedico == null || idMedico == 0) {
	            atenciones = horarioMedicoHoraService.listarTodos();
	        } else {
	            atenciones = horarioMedicoHoraService.listarPorMedico(idMedico);
	        }

	        model.addAttribute("atenciones", atenciones);
	        model.addAttribute("medicos", medicoService.listarTodos());
	        model.addAttribute("idMedicoSeleccionado", idMedico == null ? 0 : idMedico);

	        return "atenciones"; // tu vista
	    }
	
	    // Mostrar formulario para nueva atención
	    @GetMapping("/nuevo")
	    public String mostrarFormulario(Model model) {
	        model.addAttribute("atencion", new HorarioMedicoHora());
	        model.addAttribute("horarios", horarioMedicoService.listarTodos()); // Lista de HorarioMedico
	        model.addAttribute("horas", horaService.listarTodas());
	        model.addAttribute("consultorios", consultorioService.listarTodos());
	        model.addAttribute("medicos", horarioMedicoService.listarTodos()); // si deseas mostrar nombres
	        return "form-atencion"; // Asegúrate que este archivo exista
	    }
	
	    // Guardar atención
	    @PostMapping("/guardar")
	    public String guardarAtencion(@RequestParam("idHorarioMedico") String idHorarioMedico,
	    	    @RequestParam("idHora") Integer idHora,
	    	    @RequestParam("idConsultorio") Integer idConsultorio,
	    	    @RequestParam("estado") String estado) {
	
	    	    String[] partes = idHorarioMedico.split("-");
	    	    Integer idHorario = Integer.parseInt(partes[0]);
	    	    Integer idMedico = Integer.parseInt(partes[1]);
	
	    	    HorarioMedicoHoraId id = new HorarioMedicoHoraId(idHorario, idMedico, idHora);
	    	    Consultorio consultorio = consultorioService.buscarPorId(idConsultorio);
	
	    	    HorarioMedicoHora atencion = new HorarioMedicoHora();
	    	    atencion.setId(id);
	    	    atencion.setConsultorio(consultorio);
	    	    atencion.setEstado(estado);
	
	    	    horarioMedicoHoraService.guardar(atencion);
	
	    	    return "redirect:/atenciones";
	    }
	    // Eliminar atención
	    @GetMapping("/eliminar")
	    public String eliminarAtencion(@RequestParam("idHorario") Integer idHorario,
	                                   @RequestParam("idMedico") Integer idMedico,
	                                   @RequestParam("idHora") Integer idHora) {
	        HorarioMedicoHoraId id = new HorarioMedicoHoraId(idHorario, idMedico, idHora);
	        horarioMedicoHoraService.eliminarPorId(id);
	        return "redirect:/atenciones";
	    }

}
