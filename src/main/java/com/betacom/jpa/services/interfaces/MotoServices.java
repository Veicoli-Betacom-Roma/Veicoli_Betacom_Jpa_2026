package com.betacom.jpa.services.interfaces;

import java.util.List;


import com.betacom.jpa.dtos.request.MotoReq;
import com.betacom.jpa.dtos.response.MotoDTO;

public interface MotoServices {
	void create(MotoReq req) throws Exception;
	void update(MotoReq req) throws Exception;
	void delete(Integer id) throws Exception;
	List<MotoDTO> listMoto() throws Exception;

}
