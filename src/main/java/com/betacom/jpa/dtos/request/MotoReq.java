package com.betacom.jpa.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class MotoReq extends VeicoloReq{
	
	private String targa;
	private Integer cilindrata;

}
