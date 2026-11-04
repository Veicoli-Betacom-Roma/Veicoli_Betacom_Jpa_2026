package com.betacom.jpa.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dtos.request.VeicoloSearchReq;
import com.betacom.jpa.dtos.response.VeicoloDTO;
import com.betacom.jpa.mappers.VeicoloMap;
import com.betacom.jpa.models.Veicolo;
import com.betacom.jpa.repositories.VeicoloRepository;
import com.betacom.jpa.services.interfaces.VeicoloServices;
import com.betacom.jpa.services.specifications.VeicoloSpecifications;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class VeicoloServicesImpl implements VeicoloServices{

	private final VeicoloRepository veicR;

	@Override
	public List<VeicoloDTO> search(Integer id, String marca, String modello, Integer numeroRuote,
			Integer alimentazioneId, Integer coloreId, Integer categoriaId, String tipoV, String targa)
			throws Exception {
		VeicoloSearchReq vFiltered = VeicoloSearchReq.builder()
										.id(id)
										.numeroRuote(numeroRuote)
										.targa(targa)
										.alimentazioneId(alimentazioneId)
										.categoriaId(categoriaId)
										.coloreId(coloreId)
										.marca(marca)
										.modello(modello)
										.tipoV(tipoV)
										.build();
		
		log.debug("find {}", vFiltered);
		List<Veicolo> lV = veicR.findAll(VeicoloSpecifications.search(vFiltered));
		return VeicoloMap.buildVeicoloDTOs(lV);
	}


	
	
	
}
