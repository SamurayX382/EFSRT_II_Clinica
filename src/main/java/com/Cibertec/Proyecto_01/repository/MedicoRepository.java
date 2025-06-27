package com.Cibertec.Proyecto_01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Cibertec.Proyecto_01.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
	@Query("SELECT m FROM Medico m WHERE " +
	           "LOWER(m.nombre) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
	           "LOWER(m.especialidad) LIKE LOWER(CONCAT('%', :filtro, '%')) OR " +
	           "m.dni LIKE CONCAT('%', :filtro, '%')")
	    List<Medico> buscarPorNombreEspecialidadODni(@Param("filtro") String filtro);
}
