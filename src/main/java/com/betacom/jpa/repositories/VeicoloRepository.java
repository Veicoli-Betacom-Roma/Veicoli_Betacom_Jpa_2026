package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.jpa.models.Veicolo;

public interface VeicoloRepository extends 	JpaRepository<Veicolo, Integer>,
											JpaSpecificationExecutor<Veicolo>{

//	@Query(name="search.veicoli")
//	List<Veicolo> search(
//			@Param("marca") String marca,
//			@Param("modello") String modello,
//			@Param("numeroRuote") Integer numeroRuote,
//			@Param("coloreId") Integer coloreId,
//			@Param("aliimentazioneId") Integer alimentazioneId,
//			@Param("categoriaId") Integer CategoriaId
//			); 
	
}
