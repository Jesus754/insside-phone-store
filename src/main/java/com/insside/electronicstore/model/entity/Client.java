package com.insside.electronicstore.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Client extends AbstractPersistentObject {
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "dni",unique = true, nullable = false)
	private String dni;
	
	@Column(name = "adress", nullable = false)
	private String address;
	
	@Column(name = "pone_number", nullable = true)
	private String phoneNumber;
	
	
	public Client() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
