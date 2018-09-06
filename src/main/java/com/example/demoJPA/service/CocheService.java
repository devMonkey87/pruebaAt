package com.example.demoJPA.service;

import java.util.List;
import java.util.Optional;

import com.example.demoJPA.entity.Coche;
import com.example.demoJPA.entity.Persona;

public interface CocheService {

	List<Coche> geAllCoches();

	Optional<Coche> getCocheByMatricula(String matricula);

	List<Coche> getCochesByModelo(String modelo);

	List<Coche> getCochesByFabricante(String fabricante);

	//public void deleteByDni(String dni);

}
