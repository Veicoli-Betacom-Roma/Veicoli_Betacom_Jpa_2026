package com.betacom.jpa.services.specifications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.betacom.jpa.dtos.request.VeicoloSearchReq;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.models.Moto;
import com.betacom.jpa.models.Veicolo;

import jakarta.persistence.criteria.Predicate;

public class VeicoloSpecifications {
	
	public static Specification<Veicolo> search(VeicoloSearchReq req) {
		
		/*
		 * Contiene tutte le regole che vengono prese e validate se son presenti i valori
		 */
		
		return (root, query, cb) -> {
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			if(req.getId() != null) {
				predicates.add(
						cb.equal(root.get("id"), req.getId())
					);
			}
			
			if(req.getMarca() != null && !req.getMarca().isBlank()) {
				predicates.add(
						cb.like(cb.lower(root.get("marca")),
								"%" + req.getMarca().toLowerCase() + "%")
					);
			}
			
			if(req.getModello() != null && !req.getModello().isBlank()) {
				predicates.add(
						cb.like(cb.lower(root.get("modello")),
								"%" + req.getModello().toLowerCase() + "%")
					);
				
			}
			
			if(req.getNumeroRuote() != null) {
				predicates.add(
						cb.equal(root.get("numeroRuote"), req.getNumeroRuote())
					);
			}
			
			if (req.getColoreId() != null) {
                predicates.add(
                		cb.equal(root.get("colore").get("id"), req.getColoreId())
            		);
            }

            if (req.getAlimentazioneId() != null) {
                predicates.add(
                		cb.equal(root.get("alimentazione").get("id"), req.getAlimentazioneId())
            		);
            }

            if (req.getCategoriaId() != null) {
                predicates.add(
                    cb.equal(root.get("categoria").get("id"), req.getCategoriaId())
            		);
            }
            
            if(req.getTipoV() != null && !req.getTipoV().isBlank()) {
            	switch (req.getTipoV().toUpperCase()) {

                case "MACCHINA" ->
                    predicates.add(
                        cb.equal(root.type(), Macchina.class)
                    );

                case "MOTO" ->
                    predicates.add(
                        cb.equal(root.type(), Moto.class)
                    );

                case "BICI" ->
                    predicates.add(
                        cb.equal(root.type(), Bici.class)
                    );
                    
                default -> 
                	throw new IllegalArgumentException("Tipo non valido");
           }}
            	 
            	 if (req.getTarga() != null && !req.getTarga().isBlank()) {

            		    Predicate macchinaPredicate = cb.like(
            		        cb.lower(cb.treat(root, Macchina.class).<String>get("targa")),
            		        "%" + req.getTarga().toLowerCase() + "%"
            		    );

            		    Predicate motoPredicate = cb.like(
            		        cb.lower(cb.treat(root, Moto.class).<String>get("targa")),
            		        "%" + req.getTarga().toLowerCase() + "%"
            		    );

            		    predicates.add(cb.or(macchinaPredicate, motoPredicate));
            		}
            	 
            	 return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
