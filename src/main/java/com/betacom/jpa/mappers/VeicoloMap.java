package com.betacom.jpa.mappers;

import com.betacom.jpa.dtos.response.AlimentazioneDTO;
import com.betacom.jpa.dtos.response.CategoriaDTO;
import com.betacom.jpa.dtos.response.VeicoloDTO;
import com.betacom.jpa.models.Veicolo;

public class VeicoloMap {
	public static VeicoloDTO buildVeicoloDTO(Veicolo v) {
		return VeicoloDTO.builder()
				.id(v.getId())
				.marca(v.getMarca())
				.modello(v.getModello())
				.numeroRuote(v.getNumeroRuote())
				
				.alimentazione(v.getAlimentazione() != null ?
	                    AlimentazioneDTO.builder()
	                        .id(v.getAlimentazione().getId())
	                        .tipoAlimentazione(v.getAlimentazione().getTipoAlimentazione())
	                        .build() : null)
				
				.categoria(v.getCategoria() != null ?
						CategoriaDTO.builder()
						.id(v.getCategoria().getId())
						.nomeCategoria(v.getCategoria().getNomeCategoria())
						.build() :null)
				
				//non completa
				
				.build();
	}
}
