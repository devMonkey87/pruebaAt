package com.example.demoJPA.service;

import java.util.List;
import java.util.Optional;

import com.example.demoJPA.entity.Persona;

public interface PersonaService {

	List<Persona> geAllPersonas();

	Optional<Persona> getPersonaByDni(String dni);

	List<Persona> getPersonasByFechaNac(String nombre);

	List<Persona> getPersonasByNombre(String nombre);

	public String deleteByDni(String dni);

	

	public void createPersona(Persona persona);
	

	Optional<Persona> encuentraeByDni(String id);

}
