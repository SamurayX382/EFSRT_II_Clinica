package com.Cibertec.Proyecto_01.controller;

import com.Cibertec.Proyecto_01.model.Cita;
import com.Cibertec.Proyecto_01.service.CitaService;
import com.Cibertec.Proyecto_01.service.MedicoService;
import com.Cibertec.Proyecto_01.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    public CitaController(CitaService citaService, MedicoService medicoService, PacienteService pacienteService) {
        this.citaService = citaService;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
    }

    // Listar todas las citas
    @GetMapping("")
    public String listarCitas(Model model) {
        model.addAttribute("citas", citaService.listarCitas());
        return "citas/lista";
    }

    // Mostrar formulario para nueva cita
    @GetMapping("/nueva")
    public String mostrarFormularioNuevaCita(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("medicos", medicoService.listarMedicos());
        model.addAttribute("pacientes", pacienteService.listarPacientes());
        return "citas/formulario";
    }

    // Guardar cita (crear o actualizar)
    @PostMapping("/guardar")
    public String guardarCita(@ModelAttribute Cita cita) {
        citaService.guardarCita(cita);
        return "redirect:/citas";
    }

    // Editar cita
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCita(@PathVariable Long id, Model model) {
        Cita cita = citaService.obtenerCitaPorId(id);
        if (cita != null) {
            model.addAttribute("cita", cita);
            model.addAttribute("medicos", medicoService.listarMedicos());
            model.addAttribute("pacientes", pacienteService.listarPacientes());
            return "citas/formulario";
        } else {
            return "redirect:/citas";
        }
    }

    // Eliminar cita
    @GetMapping("/eliminar/{id}")
    public String eliminarCita(@PathVariable Long id) {
        citaService.eliminarCita(id);
        return "redirect:/citas";
    }
}
