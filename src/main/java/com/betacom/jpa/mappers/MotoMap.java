package com.betacom.jpa.mappers;

import java.util.List;


import com.betacom.jpa.dtos.response.MotoDTO;
import com.betacom.jpa.models.Moto;


public class MotoMap {
	
	 public static MotoDTO buildMotoDTO(Moto mo) {

	        return MotoDTO.builder()
	                .id(mo.getId())
	                .numeroRuote(mo.getNumeroRuote())
	                .marca(mo.getMarca())
	                .annoProduzione(mo.getAnnoProduzione())
	                .modello(mo.getModello())
	                .targa(mo.getTarga())
	                .cilindrata(mo.getCilindrata())
	                .alimentazioneId(mo.getAlimentazione().getId())
	                .coloreId(mo.getColore().getId())
	                .categoriaId(mo.getCategoria().getId())
	                .build();
	    }

	    
	    public static List<MotoDTO> buildMotoDTO(List<Moto> moto) {

	        return moto.stream()
	                .map(mo -> buildMotoDTO(mo))
	                .toList();
	    }
	}
