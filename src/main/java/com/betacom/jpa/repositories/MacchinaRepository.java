package com.betacom.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.models.Moto;

public interface MacchinaRepository extends JpaRepository<Macchina, Integer>{
	boolean existsByTarga(String targa);
	Optional<Macchina> findByTarga(String targa);
	
}
