package com.example.demoJPA.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJPA.entity.Coche;
import com.example.demoJPA.entity.Persona;
import com.example.demoJPA.repository.CocheRepository;
import com.example.demoJPA.repository.PersonaRepository;
import com.example.demoJPA.service.CocheService;
import com.example.demoJPA.service.PersonaService;

@Service
public class CocheSerrviceImpl implements CocheService {

	private final CocheRepository cocheRepo;

	@Autowired
	public CocheSerrviceImpl(CocheRepository cocheRepository) {

		this.cocheRepo = cocheRepository;
	}

	@Override
	public List<Coche> geAllCoches() {

		List<Coche> coches = cocheRepo.findAll();

		return coches;

	}

	@Override
	public Optional<Coche> getCocheByMatricula(String matricula) {

		Optional<Coche> coches = cocheRepo.findByMatriculaLikeIgnoreCase(matricula);

		if (!coches.isPresent()) {
			// TODO
		}
		return coches;
	}

	@Override
	public List<Coche> getCochesByModelo(String modelo) {

		return cocheRepo.findByModeloLikeIgnoreCase(modelo);

	}

	@Override
	public List<Coche> getCochesByFabricante(String fabricante) {
		return cocheRepo.findByFabricanteLikeIgnoreCase(fabricante);
	}

}
