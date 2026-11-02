package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dtos.request.BiciReq;

public interface BiciServices {
	void create(BiciReq req) throws Exception;
	void update(BiciReq req) throws Exception;
	void delete(Integer id) throws Exception;
	List<BiciDTO> listBici() throws Exception;
}
