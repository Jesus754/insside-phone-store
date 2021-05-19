package com.insside.electronicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insside.electronicstore.dto.PhoneDTO;
import com.insside.electronicstore.dto.ResponseDTO;
import com.insside.electronicstore.service.IPhoneService;

@RestController()
@RequestMapping("/electronicstore")
public class PhoneController {

	
	@Autowired
	private IPhoneService phoneServiceImpl;
	
	public IPhoneService getPhoneServiceImpl() {
		return phoneServiceImpl;
	}

	public void setPhoneServiceImpl(IPhoneService phoneServiceImpl) {
		this.phoneServiceImpl = phoneServiceImpl;
	}

	@PostMapping(path = "/phone" ,consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseDTO> createPhone(@Validated @RequestBody PhoneDTO phoneDTO) {
		Long id = this.getPhoneServiceImpl().save(phoneDTO);
		ResponseDTO response = new ResponseDTO();
		response.setId(id);
		response.setMessage("Telefono creado correctamente");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/phone/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseDTO> updatePhone(@PathVariable(name = "id") Long rquestId,@Validated @RequestBody PhoneDTO phoneDTO) {
		Long id = this.getPhoneServiceImpl().update(phoneDTO, rquestId);
		ResponseDTO response = new ResponseDTO();
		response.setId(id);
		response.setMessage("Telefono actualizado correctamente");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	
	}
	
	@DeleteMapping(path = "/phone/{id}", produces = "application/json")
	public ResponseEntity<ResponseDTO> updatePhone(@PathVariable(name = "id") Long rquestId) {
		this.getPhoneServiceImpl().delete(rquestId);
		ResponseDTO response = new ResponseDTO();
		response.setId(rquestId);
		response.setMessage("Telefono eliminado correctamente");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	
	}
	
	
}
