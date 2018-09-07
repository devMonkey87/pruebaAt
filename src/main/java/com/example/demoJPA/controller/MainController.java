package com.example.demoJPA.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJPA.entity.Coche;
import com.example.demoJPA.entity.Persona;
import com.example.demoJPA.service.CocheService;
import com.example.demoJPA.service.PersonaService;

@RestController

public class MainController {

	private final PersonaService personaService;

	private final CocheService cocheService;

	@Autowired
	public MainController(PersonaService personaServ, CocheService cocheServ) {

		this.personaService = personaServ;
		this.cocheService = cocheServ;

	}

	@RequestMapping(value = { "/personas" }, method = RequestMethod.GET)

	public List<Persona> listarTodos(@RequestParam Optional<String> nombre) {

		List<Persona> entidades = new ArrayList<>();
		if (nombre.isPresent()) {

			entidades = personaService.getPersonasByNombre(nombre.get());

		} else {

			entidades = personaService.geAllPersonas();
		}
		return entidades;

	}

	@RequestMapping(value = { "/personas/{dni}" }, method = RequestMethod.GET)

	public Persona obtienePersonaPorDni(@PathVariable String dni) {

		Optional<Persona> persona = personaService.getPersonaByDni(dni);

		return persona.get();

	}

	@DeleteMapping("/personas/{dni}")
	public String borrarUsuario(@PathVariable String dni) {
		return personaService.deleteByDni(dni);
	}

	@PostMapping("/personas")
	public ResponseEntity<Object> crearPersona(@RequestBody Persona persona) {

		personaService.createPersona(persona);

		return ResponseEntity.ok().build();

	}

	@PutMapping("/personas/{dni}")
	public ResponseEntity<Object> updatePersona(@RequestBody Persona persona, @PathVariable String dni) {

		Optional<Persona> personaOp = personaService.encuentraeByDni(dni);

		if (!personaOp.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		personaService.createPersona(persona);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = { "/coches" }, method = RequestMethod.GET)

	public List<Coche> listarTodosCoches(@RequestParam Optional<String> fabricante) {

		List<Coche> vehiculos = new ArrayList<>();
		if (fabricante.isPresent()) {

			vehiculos = cocheService.getCochesByFabricante(fabricante.get());

		} else {

			vehiculos = cocheService.geAllCoches();
		}
		return vehiculos;

	}

	@RequestMapping(value = { "/coches/{matricula}" }, method = RequestMethod.GET)

	public Coche obtieneCochePorMatricula(@PathVariable String matricula) {

		Optional<Coche> coche = cocheService.getCocheByMatricula(matricula);

		return coche.get();

	}

}
