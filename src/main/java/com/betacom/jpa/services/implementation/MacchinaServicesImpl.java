package com.betacom.jpa.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dtos.request.MacchinaReq;
import com.betacom.jpa.dtos.response.MacchinaDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.repositories.AlimentazioneRepository;
import com.betacom.jpa.repositories.CategoriaRepository;
import com.betacom.jpa.repositories.ColoreRepository;
import com.betacom.jpa.repositories.MacchinaRepository;
import com.betacom.jpa.services.interfaces.MacchinaServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MacchinaServicesImpl implements MacchinaServices{

	private final MacchinaRepository macR;
	private final CategoriaRepository catR;
	private final AlimentazioneRepository alimR;
	private final ColoreRepository colR;
	
	
	@Override
	public void create(MacchinaReq req) throws Exception {
		Macchina macchina = new Macchina();
		
		Alimentazione alim = alimR.findById(req.getAlimentazioneId())
				.orElseThrow(() -> new AcademyException("Alimentazione non trovata"));
		
		Colore colore = colR.findById(req.getColoreId())
				.orElseThrow(() -> new AcademyException("Colore non trovato"));
		
		Categoria categoria = catR.findById(req.getCategoriaId())
				.orElseThrow(() -> new AcademyException("Categoria non trovato"));
		
		macchina.setColore(colore);
		macchina.setCategoria(categoria);
		macchina.setAlimentazione(alim);
		macchina.setMarca(req.getMarca());
		macchina.setModello(req.getModello());
		macchina.setAnnoProduzione(req.getAnnoProduzione());
		macchina.setNumeroRuote(req.getNumeroRuote());
		
		macchina.setCilindrata(req.getCilindrata());
		macchina.setNumeroPorte(req.getNumeroPorte());
		macchina.setTarga(req.getTarga());
		
		macR.save(macchina);
		
	}

	@Override
	public void update(MacchinaReq req) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		
		
	}

	@Override
	public List<MacchinaDTO> listMacchina() throws Exception {
		
		return null;
	}



}
