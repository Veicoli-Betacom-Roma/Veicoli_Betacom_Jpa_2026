package com.betacom.jpa.services.interfaces;

import java.util.List;


import com.betacom.jpa.dtos.request.MacchinaReq;
import com.betacom.jpa.dtos.response.MacchinaDTO;

public interface MacchinaServices {
	void create(MacchinaReq req) throws Exception;
	void update(MacchinaReq req) throws Exception;
	void delete(Integer id) throws Exception;
	List<MacchinaDTO> listMacchina() throws Exception;
}
