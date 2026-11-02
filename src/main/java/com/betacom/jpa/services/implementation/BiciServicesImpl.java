package com.betacom.jpa.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dtos.request.BiciReq;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.repositories.AlimentazioneRepository;
import com.betacom.jpa.repositories.BiciRepository;
import com.betacom.jpa.repositories.CategoriaRepository;
import com.betacom.jpa.repositories.ColoreRepository;
import com.betacom.jpa.services.interfaces.BiciServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BiciServicesImpl implements BiciServices{
	
	private final BiciRepository biciR;
	private final CategoriaRepository catR;
	private final AlimentazioneRepository alimR;
	private final ColoreRepository colR;
	

	@Transactional
	@Override
	public void create(BiciReq req) throws Exception {
		Bici bici = new Bici();
		
		Alimentazione alim = alimR.findById(req.getAlimentazioneId())
				.orElseThrow(() -> new AcademyException("Alimentazione non trovata"));
		
		Colore colore = colR.findById(req.getColoreId())
				.orElseThrow(() -> new AcademyException("Colore non trovato"));
		
		Categoria categoria = catR.findById(req.getCategoriaId())
				.orElseThrow(() -> new AcademyException("Categoria non trovato"));
		
		bici.setColore(colore);
		bici.setCategoria(categoria);
		bici.setAlimentazione(alim);
		bici.setMarca(req.getMarca());
		bici.setModello(req.getModello());
		bici.setAnnoProduzione(req.getAnnoProduzione());
		bici.setNumeroRuote(req.getNumeroRuote());
		
		bici.setNumeroMarce(req.getNumeroMarce());
		bici.setPieghevole(req.getPieghevole());
		
		biciR.save(bici);
		
	}

	@Override
	public void update(BiciReq req) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws Exception {
				
	}

	@Override
	public List<BiciDTO> listBici() throws Exception {
		
		return null;
	}



}
