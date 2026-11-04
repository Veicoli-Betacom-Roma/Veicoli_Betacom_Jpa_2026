package com.betacom.jpa.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class VeicoloSearchReq {
	private Integer id;
	private String marca;
	private String modello;
	private Integer numeroRuote;
	private Integer alimentazioneId;
	private Integer coloreId;
	private Integer categoriaId;
	private String tipoV;
	private String targa;
}
