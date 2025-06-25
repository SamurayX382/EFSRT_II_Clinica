package com.Cibertec.Proyecto_01.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String dni;

    private String telefono;

    private LocalDate fechaNacimiento;

    @Column(length = 1000)
    private String historialMedico;

    @Column(length = 500)
    private String alergias;

    @Column(length = 500)
    private String medicamentosRecetados;

    @Column(length = 500)
    private String diagnosticos;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<ConsultaMedica> consultas;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedicamentosRecetados() {
        return medicamentosRecetados;
    }

    public void setMedicamentosRecetados(String medicamentosRecetados) {
        this.medicamentosRecetados = medicamentosRecetados;
    }

    public String getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(String diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public List<ConsultaMedica> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaMedica> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Paciente [id=" + id +
               ", nombre=" + nombre +
               ", dni=" + dni +
               ", telefono=" + telefono +
               ", fechaNacimiento=" + fechaNacimiento +
               ", historialMedico=" + historialMedico +
               ", alergias=" + alergias +
               ", medicamentosRecetados=" + medicamentosRecetados +
               ", diagnosticos=" + diagnosticos +
               ", consultas=" + consultas + "]";
    }
}
