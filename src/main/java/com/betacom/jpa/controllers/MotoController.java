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
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dtos.request.MotoReq;
import com.betacom.jpa.dtos.request.ValidationGroup;
import com.betacom.jpa.dtos.response.MotoDTO;
import com.betacom.jpa.dtos.response.ResponseDTO;
import com.betacom.jpa.services.interfaces.MotoServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rest/moto")
public class MotoController {

	private final MotoServices motoServices;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> create(@Validated(ValidationGroup.Create.class) @RequestBody MotoReq req) throws Exception {
		
		motoServices.create(req);
		 return ResponseEntity.ok(ResponseDTO.builder()
		            .msg("create succesful")
		            .build());
	}
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseDTO> update(@Validated(ValidationGroup.Update.class) @RequestBody MotoReq req) throws Exception {
		
		motoServices.update(req);
		 return ResponseEntity.ok(ResponseDTO.builder()
		            .msg("update succesful")
		            .build());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) throws Exception{
		motoServices.delete(id);
		return ResponseEntity.ok(ResponseDTO.builder()
				.msg("delete sucessfull")
				.build()
				);
	}
	
	@GetMapping("/list")
	public ResponseEntity<Object> list() throws Exception{
		List<MotoDTO> moto =  motoServices.listMoto();
		
		return ResponseEntity.ok(moto);
	}
}
