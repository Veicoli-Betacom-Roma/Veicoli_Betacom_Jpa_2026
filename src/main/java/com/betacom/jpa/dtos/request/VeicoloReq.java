package com.betacom.jpa.dtos.request;

import java.time.LocalDate;

import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class VeicoloReq {
	

	private Integer id;
	

	private Integer numeroRuote;
	

	private String marca;
	

	private LocalDate annoProduzione;
	

	private String modello;
	

	private Integer alimentazioneId;

	private Integer coloreId;

	private Integer categoriaId;
}
