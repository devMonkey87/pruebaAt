package com.example.demoJPA.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoJPA.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {
	
	Optional<Persona> findByDniLikeIgnoreCase(String dni);
	
	List<Persona> findByNombreLikeIgnoreCase(String nombre);
	
	List<Persona> findByFechaNacLikeIgnoreCase(String nombre);
	
	

	
	

	
	
	
	
	
	
	
	

}
