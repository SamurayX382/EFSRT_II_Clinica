package com.Cibertec.Proyecto_01.controller;

import com.Cibertec.Proyecto_01.model.ConsultaMedica;
import com.Cibertec.Proyecto_01.service.ConsultaMedicaService;
import com.Cibertec.Proyecto_01.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class ConsultaMedicaController {

    private final ConsultaMedicaService consultaMedicaService;
    private final PacienteService pacienteService;

    public ConsultaMedicaController(ConsultaMedicaService consultaMedicaService, PacienteService pacienteService) {
        this.consultaMedicaService = consultaMedicaService;
        this.pacienteService = pacienteService;
    }

    // Listar todas las consultas
    @GetMapping("")
    public String listarConsultas(Model model) {
        model.addAttribute("consultas", consultaMedicaService.listarConsultas());
        return "consultas/lista";
    }

    // Mostrar formulario para nueva consulta
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaConsulta(Model model) {
        model.addAttribute("consulta", new ConsultaMedica());
        model.addAttribute("pacientes", pacienteService.listarPacientes());
        return "consultas/formulario";
    }

    // Guardar consulta (crear o actualizar)
    @PostMapping("/guardar")
    public String guardarConsulta(@ModelAttribute ConsultaMedica consultaMedica) {
        consultaMedicaService.guardarConsulta(consultaMedica);
        return "redirect:/consultas";
    }

    // Editar consulta
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarConsulta(@PathVariable Long id, Model model) {
        ConsultaMedica consulta = consultaMedicaService.obtenerConsultaPorId(id);
        if (consulta != null) {
            model.addAttribute("consulta", consulta);
            model.addAttribute("pacientes", pacienteService.listarPacientes());
            return "consultas/formulario";
        } else {
            return "redirect:/consultas";
        }
    }

    // Eliminar consulta
    @GetMapping("/eliminar/{id}")
    public String eliminarConsulta(@PathVariable Long id) {
        consultaMedicaService.eliminarConsulta(id);
        return "redirect:/consultas";
    }
}
