package com.betacom.jpa.dtos.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class MotoReq extends VeicoloReq{
	
	@NotNull(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, 
			message = "Il campo non puo' essere null")
	private String targa;
	
	@Positive(message = "Il campo deve contenere un valore positivo")
	private Integer cilindrata;

}
