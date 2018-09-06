package com.example.demoJPA.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoJPA.entity.Coche;
import com.example.demoJPA.entity.Persona;

public interface CocheRepository extends JpaRepository<Coche, String> {

	Optional<Coche> findByMatriculaLikeIgnoreCase(String matricula);

	List<Coche> findByFabricanteLikeIgnoreCase(String fabricante);

	List<Coche> findByModeloLikeIgnoreCase(String modelo);

	List<Coche> findByPersonaDniLikeIgnoreCase(String dni);

}
