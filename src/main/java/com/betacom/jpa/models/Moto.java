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
@Table (name = "moto")
@ToString
public class Moto extends Veicolo{

	@Column (
			length = 15,
			nullable = false,
			unique = true
			)
	private String targa;
	
	@Column (
			nullable = false
			)
	private Integer cilindrata;
}
