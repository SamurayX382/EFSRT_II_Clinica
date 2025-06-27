package com.Cibertec.Proyecto_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Cibertec.Proyecto_01.model.Medico;
import com.Cibertec.Proyecto_01.service.MedicoService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
	
	private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    // Lista medicos
    @GetMapping("")
    public String listarMedico(@RequestParam(name = "buscar", required = false) String buscar, Model model) {
        model.addAttribute("buscar", buscar); // para mostrarlo en el input
        model.addAttribute("medicos", medicoService.buscarMedicos(buscar));
        return "medicos/lista";
    }
    
    // Mostrar formulario nuevo medico
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoMedico(Model model) {
        model.addAttribute("medico", new Medico());
        return "medicos/formulario";  // plantilla formulario
    }

    // Guardar medico
    @PostMapping("/guardar")
    public String guardarMedico(@ModelAttribute Medico medico) {
        medicoService.guardarMedico(medico);
        return "redirect:/medicos";
    }

    // Mostrar formulario editar medico
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarMedico(@PathVariable Long id, Model model) {
        Medico medico = medicoService.obtenerMedicoPorId(id);
        if (medico != null) {
            model.addAttribute("medico", medico);
            return "medicos/formulario";
        } else {
            return "redirect:/medicos";
        }
    }

    // Eliminar medico
    @GetMapping("/eliminar/{id}")
    public String eliminarMedico(@PathVariable Long id) {
        medicoService.eliminarMedico(id);
        return "redirect:/medicos";
    }
}