package com.Cibertec.Proyecto_01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Cibertec.Proyecto_01.model.Medico;
import com.Cibertec.Proyecto_01.repository.MedicoRepository;

@Service
public class MedicoService {
	
	private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    public Medico guardarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico obtenerMedicoPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public void eliminarMedico(Long id) {
    	medicoRepository.deleteById(id);
    }
}
