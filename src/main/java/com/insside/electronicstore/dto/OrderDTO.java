package com.insside.electronicstore.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class OrderDTO {
	
	@NotNull(message = "El codigo es requerido")
	private Long code;
	
	@NotNull(message = "El cliente es requerido")
	private ClientDTO client;
	
	private List<PhoneDTO> phones;

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
		
}
