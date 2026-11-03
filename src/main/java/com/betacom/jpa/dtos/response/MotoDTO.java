package com.betacom.jpa.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.SuperBuilder;
import lombok.ToString;

@Getter
@Setter
@SuperBuilder
@ToString
public class MotoDTO extends VeicoloDTO{

	private String targa;
	private Integer cilindrata;
	
}
