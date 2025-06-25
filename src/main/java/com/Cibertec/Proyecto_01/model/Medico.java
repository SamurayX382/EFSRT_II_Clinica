package com.Cibertec.Proyecto_01.model;
	import java.util.List;

import jakarta.persistence.*;

	@Entity
	public class Medico {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nombre;
	    private String especialidad;
	    private String dni;
	    private String telefono;
	    private String correo;
		
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
		public String getEspecialidad() {
			return especialidad;
		}
		public void setEspecialidad(String especialidad) {
			this.especialidad = especialidad;
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
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		
		@Override
		public String toString() {
			return "Medico [id=" + id + ", nombre=" + nombre + ", especialidad=" + especialidad + ", dni=" + dni
					+ ", telefono=" + telefono + ", correo=" + correo + "]";
		}

	   

}
