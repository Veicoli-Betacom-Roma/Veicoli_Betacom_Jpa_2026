package com.betacom.jpa.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dtos.request.BiciReq;
import com.betacom.jpa.dtos.request.MacchinaReq;
import com.betacom.jpa.dtos.request.ValidationGroup;
import com.betacom.jpa.dtos.response.BiciDTO;
import com.betacom.jpa.dtos.response.ResponseDTO;
import com.betacom.jpa.services.interfaces.BiciServices;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rest/bici")
public class BiciController {
	
	private final BiciServices biciServices;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> create(@Validated(ValidationGroup.Create.class) @RequestBody BiciReq req) throws Exception {
		
		biciServices.create(req);
		 return ResponseEntity.ok(ResponseDTO.builder()
		            .msg("create succesful")
		            .build());
	}
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseDTO> update(@Validated(ValidationGroup.Update.class) @RequestBody BiciReq req) throws Exception {
		
		biciServices.update(req);
		 return ResponseEntity.ok(ResponseDTO.builder()
		            .msg("update succesful")
		            .build());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) throws Exception{
		biciServices.delete(id);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("delete sucessfull")
				.build()
				);
	}
	
	@GetMapping("/list")
	public ResponseEntity<Object> list() throws Exception{
		List<BiciDTO> bici =  biciServices.listBici();
		
		return ResponseEntity.ok(bici);
	}
	
}
