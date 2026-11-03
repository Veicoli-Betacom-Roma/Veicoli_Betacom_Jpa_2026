package com.betacom.jpa.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlimentazioneReq {
	
	private Integer id;
	private String tipoAlimentazione;
}
