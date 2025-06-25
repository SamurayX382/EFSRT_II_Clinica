package com.Cibertec.Proyecto_01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Cibertec.Proyecto_01.model.Cita;
import com.Cibertec.Proyecto_01.repository.CitaRepository;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita obtenerCitaPorId(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }


}
