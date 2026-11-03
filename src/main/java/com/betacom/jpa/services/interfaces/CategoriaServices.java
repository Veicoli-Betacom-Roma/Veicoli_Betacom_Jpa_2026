package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dtos.request.CategoriaReq;
import com.betacom.jpa.dtos.response.CategoriaDTO;

public interface CategoriaServices {
	
	void create(CategoriaReq req) throws Exception;
	void update(CategoriaReq req) throws Exception;
	void delete(Integer id) throws Exception;
	List<CategoriaDTO> listCategoria() throws Exception;

}
