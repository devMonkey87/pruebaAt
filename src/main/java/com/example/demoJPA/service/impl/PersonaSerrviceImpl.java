package com.example.demoJPA.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJPA.entity.Persona;
import com.example.demoJPA.repository.PersonaRepository;
import com.example.demoJPA.service.PersonaService;

@Service
public class PersonaSerrviceImpl implements PersonaService {

	private final PersonaRepository personaRepo;

	@Autowired
	public PersonaSerrviceImpl(PersonaRepository personaRepository) {

		this.personaRepo = personaRepository;
	}

	@Override
	public List<Persona> geAllPersonas() {

		List<Persona> personas = personaRepo.findAll();

		return personas;
	}

	@Override
	public Optional<Persona> getPersonaByDni(String dni) {

		Optional<Persona> persona = personaRepo.findByDniLikeIgnoreCase(dni);

		if (!persona.isPresent()) {
			// TODO
		}
		return persona;

	}

	@Override
	public List<Persona> getPersonasByNombre(String nombre) {

		return personaRepo.findByNombreLikeIgnoreCase(nombre);
	}

	@Override
	public List<Persona> getPersonasByFechaNac(String fecha) {

		return personaRepo.findByFechaNacLikeIgnoreCase(fecha);

	}

	@Override
	public String deleteByDni(String dni) {
		Optional<Persona> persona = personaRepo.findById(dni);
		if (!persona.isPresent()) {

			return "No existe persona con ese DNI";

		}
		personaRepo.deleteById(dni);
		return "Usuario eliminado con éxito";
	}

//	@Override
//	public String updateByDni(String dni, String nombre, String fechaNac) {
//		
//		Optional<Persona> persona = personaRepo.findById(dni);
//		if (!persona.isPresent()) {
//
//			return "No existe persona con ese DNI";
//			
//			Persona personaSave = (Persona) persona;
//
//		}
//		personaRepo.save(entity);
//		return "Usuario eliminado con éxito";
//	}
//	}

	



	@Override
	public void createPersona(Persona persona) {
		
		personaRepo.save(persona);

	}



	@Override
	public Optional<Persona> encuentraeByDni(String id) {
		// TODO Auto-generated method stub
		return personaRepo.findById(id);

	}

}
