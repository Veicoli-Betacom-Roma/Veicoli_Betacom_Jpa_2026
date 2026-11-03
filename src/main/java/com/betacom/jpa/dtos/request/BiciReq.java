package com.betacom.jpa.dtos.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
public class BiciReq extends VeicoloReq{
	
	@NotNull(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "Il campo non puo' essere null")
	private Boolean pieghevole;
	
	@Min(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, value = 1, message = "Almeno una marcia è obbligatoria")
	private Integer numeroMarce;
}
