package com.betacom.jpa.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dtos.request.BiciReq;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.repositories.BiciRepository;
import com.betacom.jpa.services.interfaces.BiciServices;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BiciServicesImpl implements BiciServices{
	
	private final BiciRepository biciRepository;

	@Override
	public void create(BiciReq req) throws Exception {
		Bici bici = new Bici();
		
		
		
		bici.setColore(req.getColore());
		bici.setCategoria(req.getCategoria());
		bici.setAlimentazione(req.getAlimentazione());
		bici.setMarca(req.getMarca());
		bici.setModello(req.getModello());
		bici.setAnnoProduzione(req.getAnnoProduzione());
		bici.setNumeroRuote(req.getNumeroRuote());
		
		bici.setNumeroMarce(req.getNumeroMarce());
		bici.setPieghevole(req.getPieghevole());
		
		biciRepository.save(bici);
		
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
