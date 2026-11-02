package com.betacom.jpa.mappers;

import java.util.List;

import com.betacom.jpa.dtos.response.BiciDTO;
import com.betacom.jpa.models.Bici;

public class BiciMap {
	
	
    public static BiciDTO buildBiciDTO(Bici b) {

        return BiciDTO.builder()
                .id(b.getId())
                .numeroRuote(b.getNumeroRuote())
                .marca(b.getMarca())
                .annoProduzione(b.getAnnoProduzione())
                .modello(b.getModello())
                .pieghevole(b.getPieghevole())
                .numeroMarce(b.getNumeroMarce())
                .alimentazioneId(b.getAlimentazione().getId())
                .coloreId(b.getColore().getId())
                .categoriaId(b.getCategoria().getId())
                .build();
    }

    
    public static List<BiciDTO> buildBiciDTO(List<Bici> bici) {

        return bici.stream()
                .map(b -> buildBiciDTO(b))
                .toList();
    }
}
