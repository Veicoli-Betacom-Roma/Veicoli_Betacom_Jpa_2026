package com.betacom.jpa.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dtos.response.VeicoloDTO;
import com.betacom.jpa.services.interfaces.VeicoloServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rest/veicolo")
public class VeicoloController {

	private final VeicoloServices veicoloServices;
	
	@GetMapping("/search")
	public ResponseEntity<List<VeicoloDTO>> search(
			@RequestParam(required = false) Integer id,
			@RequestParam(required = false) String marca,
			@RequestParam(required = false) String modello,
			@RequestParam(required = false) Integer numeroRuote,
			@RequestParam(required = false) Integer alimentazioneId,
			@RequestParam(required = false) Integer coloreId,
			@RequestParam(required = false) Integer categoriaId,
			@RequestParam(required = false) String tipoV,
			@RequestParam(required = false) String targa
			) throws Exception{
		return ResponseEntity.ok(veicoloServices.search(id, marca, modello, numeroRuote, alimentazioneId,
				coloreId, categoriaId, tipoV, targa));
	}
	
}
