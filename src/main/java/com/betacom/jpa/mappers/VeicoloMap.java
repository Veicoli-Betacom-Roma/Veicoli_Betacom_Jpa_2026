package com.betacom.jpa.mappers;

import java.util.List;

import com.betacom.jpa.dtos.response.AlimentazioneDTO;
import com.betacom.jpa.dtos.response.CategoriaDTO;
import com.betacom.jpa.dtos.response.ColoreDTO;
import com.betacom.jpa.dtos.response.VeicoloDTO;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.models.Moto;
import com.betacom.jpa.models.Veicolo;

public class VeicoloMap {
	public static VeicoloDTO buildVeicoloDTO(Veicolo v) {
		return VeicoloDTO.builder()
				.id(v.getId())
				.marca(v.getMarca())
				.modello(v.getModello())
				.numeroRuote(v.getNumeroRuote())
				.annoProduzione(v.getAnnoProduzione())
				
				.alimentazione(v.getAlimentazione() != null ?
	                    AlimentazioneDTO.builder()
	                        .id(v.getAlimentazione().getId())
	                        .tipoAlimentazione(v.getAlimentazione().getTipoAlimentazione())
	                        .build() : null)
				
				.categoria(v.getCategoria() != null ?
						CategoriaDTO.builder()
						.id(v.getCategoria().getId())
		 				.nomeCategoria(v.getCategoria().getNomeCategoria())
						.build() : null)
				
				.colore(v.getColore() != null ?
						ColoreDTO.builder()
						.id(v.getColore().getId())
						.nomeColore(v.getColore().getNomeColore())
						.build() : null
						)
				.tipoV(
						v instanceof Macchina ? "Macchina" :
						v instanceof Moto ? "Moto" :
						v instanceof Bici ? "Bici" : null
						)
				.build();
	}
	
	public static List<VeicoloDTO> buildVeicoloDTOs(List<Veicolo> veicoli) {
		return veicoli.stream()
				.map(v -> buildVeicoloDTO(v))
				.toList();
	}
}
