package com.Cibertec.Proyecto_01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Cibertec.Proyecto_01.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>  {
	
}
