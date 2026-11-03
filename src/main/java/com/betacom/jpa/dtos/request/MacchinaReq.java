package com.betacom.jpa.dtos.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class MacchinaReq extends VeicoloReq{

	@NotNull(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, 
			message = "Il campo non puo' essere null")
	private String targa;

	@Positive(message = "Il campo deve avere un numero positivo")
	private Integer cilindrata;

	@NotNull(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class},
	        message = "Campo obbligatorio")
	@Min(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, value = 2, message = "Minimo 2 porte")
	@Max(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, value = 5, message = "Massimo 5 porte")
	private Integer numeroPorte;
}
