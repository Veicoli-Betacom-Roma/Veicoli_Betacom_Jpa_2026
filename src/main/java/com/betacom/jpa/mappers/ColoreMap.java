package com.betacom.jpa.mappers;

import java.util.List;

import com.betacom.jpa.dtos.response.AlimentazioneDTO;
import com.betacom.jpa.dtos.response.ColoreDTO;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Colore;

public class ColoreMap {

public static ColoreDTO buildColoreDTO (Colore c) {
		
		return ColoreDTO.builder()
				.id(c.getId())
				.nomeColore(c.getNomeColore())
				.build();
	}
	
	public static List<ColoreDTO> buildListColoreDTO (List<Colore> cols){
		
		return cols.stream()
				.map(c -> buildColoreDTO(c))
				.toList();
	}
}
