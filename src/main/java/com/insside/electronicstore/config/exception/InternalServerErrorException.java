package com.insside.electronicstore.config.exception;

public class InternalServerErrorException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private String message;
	
	public InternalServerErrorException() {
		
	}

	public InternalServerErrorException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
