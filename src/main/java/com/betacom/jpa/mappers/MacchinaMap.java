package com.betacom.jpa.mappers;

import java.util.List;

import com.betacom.jpa.dtos.response.MacchinaDTO;
import com.betacom.jpa.models.Macchina;

public class MacchinaMap {
	
	public static MacchinaDTO buildMacchinaDTO(Macchina m) {
		return MacchinaDTO.builder()
                .id(m.getId())
                .numeroRuote(m.getNumeroRuote())
                .marca(m.getMarca())
                .annoProduzione(m.getAnnoProduzione())
                .modello(m.getModello())
                .alimentazioneId(m.getAlimentazione().getId())
                .coloreId(m.getColore().getId())
                .categoriaId(m.getCategoria().getId())
                .targa(m.getTarga())
                .cilindrata(m.getCilindrata())
                .numeroPorte(m.getNumeroPorte())
                .build();
	}
	
	public static List<MacchinaDTO> buildMacchinaDTO(List<Macchina> macchine) {

        return macchine.stream()
                .map(m -> MacchinaMap.buildMacchinaDTO(m))
                .toList();
                
    }
	
	
}
