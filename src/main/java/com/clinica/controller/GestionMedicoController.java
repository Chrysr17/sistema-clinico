package com.clinica.controller;

import com.clinica.entity.*;
import com.clinica.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Controller
public class GestionMedicoController {

    @Autowired
    private CitaService citaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private HistoriaService historiaService;

    @Autowired
    private DiagnosticoService diagnosticoService;

    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private RecetaService recetaService;

    @Autowired
    private RecetaDetalleService recetaDetalleService;

    @Autowired
    private RecetaAnalisisService recetaAnalisisService;

    @Autowired
    private MedicamentoService medicamentoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private AnalisisService analisisService;

    @Autowired
    private AtencionService atencionService;

    //Mostrar citas asignadas
    @GetMapping("/citas")
    public String verCitasAsignadas(Model model, Principal principal) {
        Usuario usuario = usuarioService.buscarPorNombreUsuario(principal.getName());
        Medico medico = medicoService.buscarPorUsuario(usuario.getIdUsuario());
        List<Cita> citas = citaService.obtenerCitasPorMedico(medico.getIdMedico());
        model.addAttribute("citas", citas);
        return "medico/citas";
    }

    //Atender paciente
    @GetMapping("/atender/{idCita}")
    public String atenderPaciente(@PathVariable Integer idCita, Model model) {
        Cita cita = citaService.obtenerPorId(idCita);
        Paciente paciente = cita.getPaciente();
        HistoriaClinica historia = historiaService.obtenerPorPaciente(paciente.getIdPaciente());

        model.addAttribute("cita", cita);
        model.addAttribute("paciente", paciente);
        model.addAttribute("historia", historia);
        model.addAttribute("diagnostico", new Diagnostico());
        model.addAttribute("tratamiento", new Tratamiento());
        model.addAttribute("receta", new Receta());
        model.addAttribute("medicamentos", medicamentoService.listarTodos());
        model.addAttribute("analisis", analisisService.listarTodos());

        return "medico/atencion";
    }

    //Guardar atención
    @PostMapping("/guardar-atencion")
    public String guardarAtencion(
            @RequestParam Integer idCita,
            @RequestParam Integer idPaciente,
            @RequestParam Integer idMedico,
            @RequestParam String descripcionDiagnostico,
            @RequestParam String descripcionTratamiento,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam List<Integer> medicamentos,
            @RequestParam List<Integer> analisis,
            @RequestParam(required = false) String[] dosis,
            @RequestParam(required = false) String[] frecuencia,
            @RequestParam(required = false) String[] duracion,
            @RequestParam(required = false) String[] observaciones,
            @RequestParam(required = false) String observacionesGenerales
    ) {
        Cita cita = citaService.obtenerPorId(idCita);

        //Crear diagnóstico
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setDescripcion(descripcionDiagnostico);
        diagnostico.setFecha(new Timestamp(System.currentTimeMillis()));
        diagnostico.setPaciente(pacienteService.obtenerPorId(idPaciente));
        diagnostico.setMedico(medicoService.buscarPorId(idMedico));
        Diagnostico diag = diagnosticoService.registrarDiagnostico(diagnostico);

        //Crear tratamiento
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setDescripcion(descripcionTratamiento);
        tratamiento.setFechaInicio(fechaInicio);
        tratamiento.setFechaFin(fechaFin);
        tratamiento.setDiagnostico(diag);
        tratamientoService.guardarTratamiento(tratamiento);

        //Crear receta
        Receta receta = new Receta();
        receta.setPaciente(diag.getPaciente());
        receta.setMedico(diag.getMedico());
        Receta recetaGuardada = recetaService.registrarReceta(receta);

        // Guardar medicamentos
        for (int i = 0; i < medicamentos.size(); i++) {
            Medicamento medicamento = new Medicamento();
            medicamento.setIdMedicamento(medicamentos.get(i));

            RecetaDetalle detalle = new RecetaDetalle();
            detalle.setReceta(recetaGuardada);
            detalle.setMedicamento(medicamento);
            detalle.setDosis(dosis[i]);
            detalle.setFrecuencia(frecuencia[i]);
            detalle.setDuracion(duracion[i]);

            recetaDetalleService.guardarDetalle(detalle);
        }

        //Guardar análisis
        for (int i = 0; i < analisis.size(); i++) {
            Analisis a = new Analisis();
            a.setIdAnalisis(analisis.get(i));

            RecetaAnalisis ra = new RecetaAnalisis();
            ra.setReceta(recetaGuardada);
            ra.setAnalisis(a);
            ra.setObservaciones(observaciones != null && observaciones.length > i ? observaciones[i] : null);

            recetaAnalisisService.guardar(ra);
        }

        //Guardar atención
        Atencion atencion = new Atencion();
        atencion.setCita(cita);
        atencion.setDiagnostico(diag);
        atencion.setTratamiento(tratamiento);
        atencion.setReceta(recetaGuardada);
        atencion.setFechaAtencion(new Timestamp(System.currentTimeMillis()));
        atencion.setObservacionesGenerales(observacionesGenerales);

        atencionService.guardarAtencion(atencion);

        return "redirect:/atenciones-medicas";
    }


    @GetMapping("/atenciones-medicas")
    public String listarAtenciones(Model model, Principal principal) {
        Usuario usuario = usuarioService.buscarPorNombreUsuario(principal.getName());
        Medico medico = medicoService.buscarPorUsuario(usuario.getIdUsuario());

        List<Atencion> atenciones = atencionService.listarPorMedico(medico.getIdMedico());
        model.addAttribute("atenciones", atenciones);

        return "medico/lista-atenciones";
    }

    @GetMapping("/atencion/imprimir/{id}")
    public String imprimirAtencion(@PathVariable("id") Integer idAtencion, Model model) {
        Atencion atencion = atencionService.obtenerPorId(idAtencion);
        model.addAttribute("atencion", atencion);
        return "medico/imprimir-atencion";
    }
}
