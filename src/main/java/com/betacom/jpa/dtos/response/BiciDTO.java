package com.betacom.jpa.dtos.response;



import lombok.Getter;
import lombok.Setter;
import lombok.SuperBuilder;
import lombok.ToString;

@Getter
@Setter
@SuperBuilder
@ToString
public class BiciDTO extends VeicoloDTO {
	
	private Boolean pieghevole;
	private Integer numeroMarce;
	
}
