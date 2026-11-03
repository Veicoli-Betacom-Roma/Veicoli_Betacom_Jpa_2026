package com.betacom.jpa.mappers;

import java.util.List;

import com.betacom.jpa.dtos.response.MotoDTO;
import com.betacom.jpa.dtos.response.AlimentazioneDTO;
import com.betacom.jpa.dtos.response.ColoreDTO;
import com.betacom.jpa.dtos.response.CategoriaDTO;
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

                .alimentazione(mo.getAlimentazione() != null ?
                    AlimentazioneDTO.builder()
                        .id(mo.getAlimentazione().getId())
                        .tipoAlimentazione(mo.getAlimentazione().getTipoAlimentazione())
                        .build() : null)

                .colore(mo.getColore() != null ?
                    ColoreDTO.builder()
                        .id(mo.getColore().getId())
                        .nomeColore(mo.getColore().getNomeColore())
                        .build() : null)

                .categoria(mo.getCategoria() != null ?
                    CategoriaDTO.builder()
                        .id(mo.getCategoria().getId())
                        .nomeCategoria(mo.getCategoria().getNomeCategoria())
                        .build() : null)

                .build();
    }

    public static List<MotoDTO> buildMotoDTO(List<Moto> moto) {

        return moto.stream()
                .map(mo -> buildMotoDTO(mo))
                .toList();
    }
}