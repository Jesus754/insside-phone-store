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

import com.insside.electronicstore.dto.ClientDTO;
import com.insside.electronicstore.dto.ResponseDTO;
import com.insside.electronicstore.service.IClientService;

@RestController()
@RequestMapping("/electronicstore")
public class ClientController {

	
	@Autowired
	private IClientService clientService;
	
	public IClientService getClientServiceImpl() {
		return clientService;
	}

	public void setPhoneServiceImpl(IClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping(path = "/client" ,consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseDTO> createClient( @Validated @RequestBody ClientDTO clientDTO) {
		Long id = this.getClientServiceImpl().save(clientDTO);
		ResponseDTO response = new ResponseDTO();
		response.setId(id);
		response.setMessage("Cliente creado correctamente");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/client/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseDTO> updatePhone(@PathVariable(name = "id") Long requestId,@Validated @RequestBody ClientDTO clientDTO) {
		Long id = this.getClientServiceImpl().update(clientDTO, requestId);
		ResponseDTO response = new ResponseDTO();
		response.setId(id);
		response.setMessage("Cliente actualizado correctamente");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	
	}
	
	@DeleteMapping(path = "/client/{id}", produces = "application/json")
	public ResponseEntity<ResponseDTO> updatePhone(@PathVariable(name = "id") Long requestId) {
		this.getClientServiceImpl().delete(requestId);
		ResponseDTO response = new ResponseDTO();
		response.setId(requestId);
		response.setMessage("Cliente eliminado correctamente");
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	
}