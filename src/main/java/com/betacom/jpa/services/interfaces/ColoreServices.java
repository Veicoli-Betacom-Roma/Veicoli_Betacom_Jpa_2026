package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dtos.request.ColoreReq;
import com.betacom.jpa.dtos.response.ColoreDTO;

public interface ColoreServices {

	void create(ColoreReq req) throws Exception;
	void update(ColoreReq req) throws Exception;
	void delete(Integer id) throws Exception;
	List<ColoreDTO> listColore() throws Exception;
}
