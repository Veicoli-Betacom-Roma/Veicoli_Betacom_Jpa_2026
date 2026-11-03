package com.betacom.jpa.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.betacom.jpa.dtos.response.ResponseDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionManager {
	
	 @ExceptionHandler(AcademyException.class)
	    public ResponseEntity<ResponseDTO> handlerAcademyException(AcademyException e) {

	        return ResponseEntity.badRequest()
	                .body(ResponseDTO.builder()
	                        .msg(e.getMessage())
	                        .build());
	    }

	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ResponseDTO> handlerValidationException(MethodArgumentNotValidException e) {

	        String msg = e.getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .findFirst()
	                .map(FieldError::getDefaultMessage)
	                .orElse("Errore di validazione");

	        return ResponseEntity.badRequest()
	                .body(ResponseDTO.builder()
	                        .msg(msg)
	                        .build());
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ResponseDTO> handlerException(Exception e) {

	        log.error("Errore imprevisto", e);

	        return ResponseEntity.internalServerError()
	                .body(ResponseDTO.builder()
	                        .msg("Errore interno del server")
	                        .build());
	    }

}
