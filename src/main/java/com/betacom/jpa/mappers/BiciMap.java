package com.betacom.jpa.mappers;

import java.util.List;

import com.betacom.jpa.dtos.response.BiciDTO;
import com.betacom.jpa.dtos.response.AlimentazioneDTO;
import com.betacom.jpa.dtos.response.ColoreDTO;
import com.betacom.jpa.dtos.response.CategoriaDTO;
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

                .alimentazione(b.getAlimentazione() != null ?
                    AlimentazioneDTO.builder()
                        .id(b.getAlimentazione().getId())
                        .tipoAlimentazione(b.getAlimentazione().getTipoAlimentazione())
                        .build() : null)

                .colore(b.getColore() != null ?
                    ColoreDTO.builder()
                        .id(b.getColore().getId())
                        .nomeColore(b.getColore().getNomeColore())
                        .build() : null)

                .categoria(b.getCategoria() != null ?
                    CategoriaDTO.builder()
                        .id(b.getCategoria().getId())
                        .nomeCategoria(b.getCategoria().getNomeCategoria())
                        .build() : null)

                .build();
    }

    public static List<BiciDTO> buildBiciDTO(List<Bici> bici) {

        return bici.stream()
                .map(b -> buildBiciDTO(b))
                .toList();
    }
}