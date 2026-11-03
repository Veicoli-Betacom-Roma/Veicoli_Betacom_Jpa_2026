package com.betacom.jpa.services.implementation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dtos.request.BiciReq;
import com.betacom.jpa.dtos.request.MotoReq;
import com.betacom.jpa.dtos.response.BiciDTO;
import com.betacom.jpa.dtos.response.MotoDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.mappers.BiciMap;
import com.betacom.jpa.mappers.MotoMap;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.models.Moto;
import com.betacom.jpa.repositories.AlimentazioneRepository;
import com.betacom.jpa.repositories.BiciRepository;
import com.betacom.jpa.repositories.CategoriaRepository;
import com.betacom.jpa.repositories.ColoreRepository;
import com.betacom.jpa.repositories.MotoRepository;
import com.betacom.jpa.services.interfaces.MotoServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MotoServicesImpl implements MotoServices {
	
	private final MotoRepository motoR;
	private final CategoriaRepository catR;
	private final AlimentazioneRepository alimR;
	private final ColoreRepository colR;
	

	@Transactional
	@Override
	public void create(MotoReq req) throws Exception {
		
		 if (motoR.existsByTarga(req.getTarga())) {
		        throw new AcademyException("Targa già esistente");
		    }
		
		Moto moto = new Moto();
		
		Alimentazione alim = alimR.findById(req.getAlimentazioneId())
				.orElseThrow(() -> new AcademyException("Alimentazione non trovata"));
		
		Colore colore = colR.findById(req.getColoreId())
				.orElseThrow(() -> new AcademyException("Colore non trovato"));
		
		Categoria categoria = catR.findById(req.getCategoriaId())
				.orElseThrow(() -> new AcademyException("Categoria non trovato"));
		
		moto.setColore(colore);
		moto.setCategoria(categoria);
		moto.setAlimentazione(alim);
		moto.setMarca(req.getMarca());
		moto.setModello(req.getModello());
		moto.setAnnoProduzione(req.getAnnoProduzione());
		moto.setNumeroRuote(req.getNumeroRuote());
		
		moto.setTarga(req.getTarga());
		moto.setCilindrata(req.getCilindrata());
		
		motoR.save(moto);
	}
	
	@Override
	public void update(MotoReq req) throws Exception {
		
		Moto moto = motoR.findById(req.getId())
	            .orElseThrow(() -> new AcademyException("Moto non trovata"));

	    Moto check = motoR.findByTarga(req.getTarga()).orElse(null);

	    if (check != null && !check.getId().equals(req.getId())) { // se l'id della moto è diverso da quello che dobbiamo aggiornare, diamo eccezione
	        throw new AcademyException("Targa già esistente");
	    }
		
		
		Alimentazione alim = alimR.findById(req.getAlimentazioneId())
				.orElseThrow(() -> new AcademyException("Alimentazione non trovata"));
		
		Colore colore = colR.findById(req.getColoreId())
				.orElseThrow(() -> new AcademyException("Colore non trovato"));
		
		Categoria categoria = catR.findById(req.getCategoriaId())
				.orElseThrow(() -> new AcademyException("Categoria non trovato"));
		
		moto.setColore(colore);
		moto.setCategoria(categoria);
		moto.setAlimentazione(alim);
		moto.setMarca(req.getMarca());
		moto.setModello(req.getModello());
		moto.setAnnoProduzione(req.getAnnoProduzione());
		moto.setNumeroRuote(req.getNumeroRuote());
		
		moto.setTarga(req.getTarga());
		moto.setCilindrata(req.getCilindrata());
		
		motoR.save(moto);
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		log.debug("moto {}", id);
		Moto moto = motoR.findById(id)
				.orElseThrow(() -> new AcademyException("moto non trovata"));
		
		motoR.delete(moto);		
	}

	@Override
	public List<MotoDTO> listMoto() throws Exception {

	    List<Moto> moto = motoR.findAll();
	    return MotoMap.buildMotoDTO(moto);
	}


}
