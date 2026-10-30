package com.betacom.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@PrimaryKeyJoinColumn (name = "id")
@Entity
@Table (name = "bici")
@ToString
public class Bici extends Veicolo{

	@Column(
			nullable = false
			)
	private Boolean pieghevole;
	
	@Column (
			name = "numero_marce",
			nullable = false
			)
	private Integer numeroMarce;
}
