package com.betacom.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table (name = "alimentazione")
@ToString
public class Alimentazione {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column (
			name = "tipo_alimentazione",
			length = 25,
			nullable = false
			)
	private String tipoAlimentazione;
	
	
}
