package com.Cibertec.Proyecto_01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Cibertec.Proyecto_01.model.ConsultaMedica;
import com.Cibertec.Proyecto_01.repository.ConsultaMedicaRepository;

@Service
public class ConsultaMedicaService {

    private final ConsultaMedicaRepository consultaMedicaRepository;

    public ConsultaMedicaService(ConsultaMedicaRepository consultaMedicaRepository) {
        this.consultaMedicaRepository = consultaMedicaRepository;
    }

    public List<ConsultaMedica> listarConsultas() {
        return consultaMedicaRepository.findAll();
    }

    public ConsultaMedica guardarConsulta(ConsultaMedica consultaMedica) {
        return consultaMedicaRepository.save(consultaMedica);
    }

    public ConsultaMedica obtenerConsultaPorId(Long id) {
        return consultaMedicaRepository.findById(id).orElse(null);
    }

    public void eliminarConsulta(Long id) {
        consultaMedicaRepository.deleteById(id);
    }
}


