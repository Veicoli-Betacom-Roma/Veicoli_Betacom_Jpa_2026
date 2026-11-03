package com.betacom.jpa.mappers;

import java.util.List;

import com.betacom.jpa.dtos.response.AlimentazioneDTO;
import com.betacom.jpa.models.Alimentazione;

public class AlimentazioneMap {

	public static AlimentazioneDTO buildAlimentazioneDTO (Alimentazione a) {
		
		return AlimentazioneDTO.builder()
				.id(a.getId())
				.tipoAlimentazione(a.getTipoAlimentazione())
				.build();
	}
	
	public static List<AlimentazioneDTO> buildListAlimentazioneDTO (List<Alimentazione> ali){
		
		return ali.stream()
				.map(a -> buildAlimentazioneDTO(a))
				.toList();
	}
}
