package com.betacom.jpa.dtos.response;

import java.time.LocalDate;


import lombok.Getter;
import lombok.Setter;
import lombok.SuperBuilder;
import lombok.ToString;

@Getter
@Setter
@SuperBuilder
@ToString
public class VeicoloDTO {
    private Integer id;
	private Integer numeroRuote;
    private String marca;
	private LocalDate annoProduzione;
	private String modello;
	private AlimentazioneDTO alimentazione;
    private ColoreDTO colore;
    private CategoriaDTO categoria;

}
