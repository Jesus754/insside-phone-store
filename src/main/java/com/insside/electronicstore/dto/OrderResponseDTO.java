package com.insside.electronicstore.dto;

import java.util.Date;
import java.util.List;

public class OrderResponseDTO {

	private Long code;
	
	private Date date;
	
	private Long total;
	
	private ClientDTO client;
	
	private List<PhoneDTO> phones;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

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

}
