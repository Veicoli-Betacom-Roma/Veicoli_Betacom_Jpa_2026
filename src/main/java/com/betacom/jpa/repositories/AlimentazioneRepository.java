package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.models.Alimentazione;

public interface AlimentazioneRepository extends JpaRepository<Alimentazione, Integer>{

	Boolean existsByTipoAlimentazione(String tipoAlimentazione);
}
