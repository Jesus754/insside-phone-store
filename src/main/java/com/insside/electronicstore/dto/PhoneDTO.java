package com.insside.electronicstore.dto;

import javax.validation.constraints.NotNull;

public class PhoneDTO {
	
	@NotNull
	private String code; 
	
	@NotNull
	private String brand;
	
	@NotNull
	private String model;
	
	@NotNull
	private Long price;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
	
}
