package com.tradeledger.cards.dto;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;


@Getter
@ToString
public final class Applicant {

	@NotNull
	private String name;
	
	@NotNull
	private String address;
	
	@NotNull
	private String email;
	
	public Applicant() {}
	
	public Applicant(String name, String email, String address) {
		
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
}
