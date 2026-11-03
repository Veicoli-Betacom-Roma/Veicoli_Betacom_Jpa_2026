package com.betacom.jpa.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dtos.request.ColoreReq;
import com.betacom.jpa.dtos.response.BiciDTO;
import com.betacom.jpa.dtos.response.ColoreDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.mappers.ColoreMap;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.repositories.ColoreRepository;
import com.betacom.jpa.services.interfaces.ColoreServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ColoreServicesImpl implements ColoreServices{
	
	private ColoreRepository colR;
	
	@Override
	public void create(ColoreReq req) throws Exception {
	log.debug("create {}", req);
	
	if (colR.existsByNomeColore(req.getNomeColore()))
		throw new AcademyException("colore presente in DB");
	
	Colore c = new Colore();
	c.setNomeColore(req.getNomeColore());
	}

	@Override
	public void update(ColoreReq req) throws Exception {
		log.debug("update {}", req);
		Colore c = colR.findById(req.getId())
				.orElseThrow(() -> new AcademyException("colore non trovato"));
		
		if (req.getNomeColore() != null && !req.getNomeColore().equalsIgnoreCase(c.getNomeColore())) {
			if (colR.existsByNomeColore(req.getNomeColore()))
				throw new AcademyException("colore presente in DB");
			c.setNomeColore(req.getNomeColore());
		}
	}

	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		Colore c = colR.findById(id)
				.orElseThrow(() -> new AcademyException("colore non trovato"));
		colR.delete(c);
	}

	@Override
	public List<ColoreDTO> listColore() throws Exception {
		List<Colore> lC = colR.findAll();
		return ColoreMap.buildListColoreDTO(lC);
	}

	
}
