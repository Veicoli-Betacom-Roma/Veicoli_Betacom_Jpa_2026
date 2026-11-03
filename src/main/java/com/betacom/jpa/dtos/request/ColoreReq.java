package com.betacom.jpa.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ColoreReq {

	@NotNull(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "Il campo non puo' essere null")
	private Integer id;
	
	 @NotNull(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "Il campo non puo' essere null")
	 @NotBlank(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "Il campo non puo' contenere spazi")
	 @Size( groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, max = 50, message = "Il campo puo' contenere al massimo 50 caratteri")
	private String nomeColore;
}
