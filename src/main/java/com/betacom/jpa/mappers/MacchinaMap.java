package com.betacom.jpa.mappers;

import java.util.List;

import com.betacom.jpa.dtos.response.MacchinaDTO;
import com.betacom.jpa.dtos.response.AlimentazioneDTO;
import com.betacom.jpa.dtos.response.ColoreDTO;
import com.betacom.jpa.dtos.response.CategoriaDTO;
import com.betacom.jpa.models.Macchina;

public class MacchinaMap {

    public static MacchinaDTO buildMacchinaDTO(Macchina m) {

        return MacchinaDTO.builder()
                .id(m.getId())
                .numeroRuote(m.getNumeroRuote())
                .marca(m.getMarca())
                .annoProduzione(m.getAnnoProduzione())
                .modello(m.getModello())

                .alimentazione(m.getAlimentazione() != null ?
                    AlimentazioneDTO.builder()
                        .id(m.getAlimentazione().getId())
                        .tipoAlimentazione(m.getAlimentazione().getTipoAlimentazione())
                        .build() : null)

                .colore(m.getColore() != null ?
                    ColoreDTO.builder()
                        .id(m.getColore().getId())
                        .nomeColore(m.getColore().getNomeColore())
                        .build() : null)

                .categoria(m.getCategoria() != null ?
                    CategoriaDTO.builder()
                        .id(m.getCategoria().getId())
                        .nomeCategoria(m.getCategoria().getNomeCategoria())
                        .build() : null)

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