package com.Cibertec.Proyecto_01.controller;

import com.Cibertec.Proyecto_01.model.Paciente;
import com.Cibertec.Proyecto_01.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

	private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // Lista pacientes
    @GetMapping("")
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.listarPacientes());
        return "pacientes/lista";  // plantilla Thymeleaf para mostrar lista
    }

    // Mostrar formulario nuevo paciente
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoPaciente(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "pacientes/formulario";  // plantilla formulario
    }

    // Guardar paciente
    @PostMapping("/guardar")
    public String guardarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.guardarPaciente(paciente);
        return "redirect:/pacientes";
    }

    // Mostrar formulario editar paciente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPaciente(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.obtenerPacientePorId(id);
        if (paciente != null) {
            model.addAttribute("paciente", paciente);
            return "pacientes/formulario";
        } else {
            return "redirect:/pacientes";
        }
    }

    // Eliminar paciente
    @GetMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return "redirect:/pacientes";
    }
}
