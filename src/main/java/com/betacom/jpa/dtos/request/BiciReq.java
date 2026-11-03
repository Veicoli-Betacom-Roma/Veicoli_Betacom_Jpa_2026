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
public class BiciReq extends VeicoloReq{
	
	private Boolean pieghevole;

	private Integer numeroMarce;
}
