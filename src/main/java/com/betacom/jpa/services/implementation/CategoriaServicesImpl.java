package com.betacom.jpa.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dtos.request.CategoriaReq;
import com.betacom.jpa.dtos.response.CategoriaDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.mappers.CategoriaMap;
import com.betacom.jpa.mappers.ColoreMap;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.repositories.CategoriaRepository;
import com.betacom.jpa.services.interfaces.CategoriaServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoriaServicesImpl implements CategoriaServices{
	
	private CategoriaRepository catR;

	@Override
	public void create(CategoriaReq req) throws Exception {
		log.debug("create {}", req);
		
		if (catR.existsByNome(req.getNomeCategoria()))
			throw new AcademyException("categoria presente in DB");
		
		Categoria c = new Categoria();
		c.setNomeCategoria(req.getNomeCategoria());
	}

	@Override
	public void update(CategoriaReq req) throws Exception {
		log.debug("update {}", req);
		Categoria c = catR.findById(req.getId())
				.orElseThrow(() -> new AcademyException("categoria non trovata"));
		
		if (req.getNomeCategoria() != null && !req.getNomeCategoria().equalsIgnoreCase(c.getNomeCategoria())) {
			if (catR.existsByNome(req.getNomeCategoria()))
				throw new AcademyException("categoria presente in DB");
			c.setNomeCategoria(req.getNomeCategoria());
		} 
	} 

	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		Categoria c = catR.findById(id)
				.orElseThrow(() -> new AcademyException("categoria non trovato"));
		catR.delete(c);
	}

	@Override
	public List<CategoriaDTO> listCategoria() throws Exception {
		List<Categoria> lC = catR.findAll();
		return CategoriaMap.buildListCategoriaDTO(lC);
	}

	
}
