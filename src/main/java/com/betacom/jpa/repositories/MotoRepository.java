package com.betacom.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.models.Moto;

public interface MotoRepository extends JpaRepository<Moto, Integer>{

	boolean existsByTarga(String targa);
	Optional<Moto> findByTarga(String targa);
	
}
