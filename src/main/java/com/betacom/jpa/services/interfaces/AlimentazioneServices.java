package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dtos.request.AlimentazioneReq;
import com.betacom.jpa.dtos.response.AlimentazioneDTO;

public interface AlimentazioneServices {

	void create(AlimentazioneReq req) throws Exception;
	void update(AlimentazioneReq req) throws Exception;
	void delete(Integer id) throws Exception;
	List<AlimentazioneDTO> listAlimentazione() throws Exception;
}
