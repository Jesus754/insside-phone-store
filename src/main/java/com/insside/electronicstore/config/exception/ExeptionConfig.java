package com.insside.electronicstore.config.exception;


import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.insside.electronicstore.dto.ErrorResponseDTO;

@ControllerAdvice
public class ExeptionConfig {
	


	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({BadRequestException.class,org.hibernate.exception.ConstraintViolationException.class})
	@ResponseBody
    public ErrorResponseDTO badRequest( Exception exception) {
		return new ErrorResponseDTO(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({NotFoundException.class})
	@ResponseBody
    public ErrorResponseDTO NotFound( Exception exception) {
		return new ErrorResponseDTO(HttpStatus.NOT_FOUND, exception.getMessage());
    }
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({DataAccessException.class})
	@ResponseBody
    public ErrorResponseDTO InternalServerError(Exception exception) {
		return new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
	
}