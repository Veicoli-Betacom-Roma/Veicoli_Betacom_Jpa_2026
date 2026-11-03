package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	Boolean existsByNomeCategoria(String nomeCategoria);
}
