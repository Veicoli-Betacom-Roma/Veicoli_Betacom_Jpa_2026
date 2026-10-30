package com.betacom.jpa.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table (name = "veicoli")
@Inheritance (strategy = InheritanceType.JOINED)
@ToString
public class Veicolo {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (
			name = "numero_ruote",
			nullable = false	
			)
	private Integer numeroRuote;
	
	@Column (
			length = 50,
			nullable = false
			)
	private String marca;
	
	@Column (
			nullable = false
			)
	private LocalDate annoProduzione;
	
	@Column (
			length = 100,
			nullable = false
			)
	private String modello;
	
	
	@ManyToOne
	@JoinColumn (name = "alimentazione_id")
	private Alimentazione alimentazione;
	
	@ManyToOne
	@JoinColumn (name = "colore_id")
	private Colore colore;

	@ManyToOne
	@JoinColumn (name = "categoria_id")
	private Categoria categoria;
	
		
	
}
