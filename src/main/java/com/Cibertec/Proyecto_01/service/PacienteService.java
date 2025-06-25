package com.Cibertec.Proyecto_01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Cibertec.Proyecto_01.model.Paciente;
import com.Cibertec.Proyecto_01.repository.PacienteRepository;
 
@Service
public class PacienteService {

	private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente obtenerPacientePorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}

