package com.betacom.jpa.dtos.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BiciReq extends VeicoloReq{


	private Boolean pieghevole;

	private Integer numeroMarce;
}
