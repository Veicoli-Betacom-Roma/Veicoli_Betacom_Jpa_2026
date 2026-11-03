package com.betacom.jpa.mappers;

import java.util.List;

import com.betacom.jpa.dtos.response.CategoriaDTO;
import com.betacom.jpa.models.Categoria;

public class CategoriaMap {

	public static CategoriaDTO buildCategoriaDTO (Categoria c) {
		
		return CategoriaDTO.builder()
				.id(c.getId())
				.nomeCategoria(c.getNomeCategoria())
				.build();
	}
	
	public static List<CategoriaDTO> buildListCategoriaDTO (List<Categoria> cats){
		
		return cats.stream()
				.map(c -> buildCategoriaDTO(c))
				.toList();
	}
}
