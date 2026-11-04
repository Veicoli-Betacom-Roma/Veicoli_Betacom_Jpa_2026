package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dtos.response.VeicoloDTO;

public interface VeicoloServices {
	List<VeicoloDTO> search(
			Integer id,
			String marca,
			String modello,
			Integer numeroRuote,
			Integer alimentazioneId,
			Integer coloreId,
			Integer categoriaId,
			String tipoV,
			String targa
			) throws Exception;
}
