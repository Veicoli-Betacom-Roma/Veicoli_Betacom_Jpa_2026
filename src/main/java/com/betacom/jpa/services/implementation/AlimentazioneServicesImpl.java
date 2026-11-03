package com.betacom.jpa.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dtos.request.AlimentazioneReq;
import com.betacom.jpa.dtos.response.AlimentazioneDTO;
import com.betacom.jpa.dtos.response.BiciDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.mappers.AlimentazioneMap;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.repositories.AlimentazioneRepository;
import com.betacom.jpa.services.interfaces.AlimentazioneServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlimentazioneServicesImpl implements AlimentazioneServices{

	private AlimentazioneRepository aliR;
	
	@Override
	public void create(AlimentazioneReq req) throws Exception {
		log.debug("create {}", req);
		
		if (aliR.existsByTipo(req.getTipoAlimentazione()))
			throw new AcademyException("alimentazione presente in DB");
		
		Alimentazione a = new Alimentazione();
		a.setTipoAlimentazione(req.getTipoAlimentazione());
	}

	@Override
	public void update(AlimentazioneReq req) throws Exception {
		log.debug("update {}", req);
		Alimentazione a = aliR.findById(req.getId())
				.orElseThrow(() -> new AcademyException("Alimentazione non trovata"));
		
		if (req.getTipoAlimentazione() != null && !req.getTipoAlimentazione().equalsIgnoreCase(a.getTipoAlimentazione())) {
			if (aliR.existsByTipo(req.getTipoAlimentazione()))
				throw new AcademyException("alimentazione presente in DB");
		a.setTipoAlimentazione(req.getTipoAlimentazione());
		}		
	}

	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		Alimentazione a = aliR.findById(id)
				.orElseThrow(() -> new AcademyException("Alimentazione non trovata"));
		aliR.delete(a);
	}

	@Override
	public List<AlimentazioneDTO> listAlimentazione() throws Exception {
		List<Alimentazione> lA = aliR.findAll();
		return AlimentazioneMap.buildListAlimentazioneDTO(lA);
	}

}
