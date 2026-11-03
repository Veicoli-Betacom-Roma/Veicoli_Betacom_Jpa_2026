package com.betacom.jpa.dtos.request;

import java.time.LocalDate;

import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
	
	@NotNull(groups = ValidationGroup.Update.class, message = "Il campo id è obbligatorio")
	private Integer id;
	
	@NotNull(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "Il campo non puo' essere null")
	@Min(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, value = 2, message = "Il veicolo deve avere almeno 2 ruote")
	@Max(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, value = 5, message = "Il veicolo puo' avere massimo 5 ruote")
	private Integer numeroRuote;
	
	 @NotBlank(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class},
	            message = "Marca obbligatoria")
	 @NotNull(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "il campo marca non puo' essere null")
	 @Size(max = 30, message = "Marca troppo lunga")
	private String marca;
	
	 @NotNull(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class},
	            message = "Data obbligatoria")
	@PastOrPresent(message = "Data non valida")
	private LocalDate annoProduzione;
	
	@NotBlank(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "Il campo modello non puo' essere vuoto")
	@NotNull( groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "Il campo modello non puo' essere null")
	private String modello;
	
	@Positive(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "Il campo dev'essere maggiore di 0")
	 @NotNull(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class},
     message = "id alimentazione obbligatoria")
	private Integer alimentazioneId;
	
	@Positive(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "Il campo dev'essere maggiore di 0")
	 @NotNull(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class},
     message = "id colore obbligatorio")
	private Integer coloreId;

	@Positive(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "Il campo dev'essere maggiore di 0")
	 @NotNull(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class},
     message = "id categoria obbligatorio")
	private Integer categoriaId;
}
