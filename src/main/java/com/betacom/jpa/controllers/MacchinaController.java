package com.betacom.jpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dtos.request.MacchinaReq;
import com.betacom.jpa.dtos.response.ResponseDTO;
import com.betacom.jpa.services.interfaces.BiciServices;
import com.betacom.jpa.services.interfaces.MacchinaServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rest/macchina")
public class MacchinaController {
	
	private final MacchinaServices macchinaServices;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> create(MacchinaReq req) {
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.CREATED;
		try {
			 macchinaServices.create(req);
			 r.setMsg("create successfull");
		} catch (Exception e) {
			log.error("Error {}", (e.getCause()));
			status = HttpStatus.BAD_REQUEST;
			r.setMsg(e.getMessage());
		}
		return ResponseEntity.status(status).body(r);
	}
}
