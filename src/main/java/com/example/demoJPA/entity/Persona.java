package com.example.demoJPA.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity

@Table(name = "persona")
public class Persona {

	@Id
	@Column(name = "Dni")
	private String dni;

	@Column(name = "Nombre", nullable = true)
	private String nombre;

	@Column(name = "Fecha_nac", nullable = true)
	private String fechaNac;

	@OneToMany(mappedBy = "persona")
	private List<Coche> coches = new ArrayList<Coche>();

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

//	public List<Coche> getCoches() {
//		return coches;
//	}
//
//	public void setCoches(List<Coche> coches) {
//		this.coches = coches;
//	}

	public Persona(String dni, String nombre, String fechaNac, List<Coche> coches) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		// this.coches = coches;
	}

	public Persona() {
		super();
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", fechaNac=" + fechaNac + "]";
	}

//	@Override
//	public String toString() {
//		return "Persona [dni=" + dni + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", coches=" + coches + "]";
//	}

}
