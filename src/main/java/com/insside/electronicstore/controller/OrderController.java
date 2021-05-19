package com.insside.electronicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insside.electronicstore.dto.OrderDTO;
import com.insside.electronicstore.dto.OrderResponseDTO;
import com.insside.electronicstore.dto.ResponseDTO;
import com.insside.electronicstore.service.IOrderService;

@RestController()
@RequestMapping("/electronicstore")
public class OrderController {

	@Autowired
	private IOrderService orderServiceImpl;

	public IOrderService getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public void setOrderServiceImpl(IOrderService orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}

	@PostMapping(path = "/order", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseDTO> createOrder(@Validated @RequestBody OrderDTO orderDTO) {
		Long id = this.getOrderServiceImpl().save(orderDTO);
		ResponseDTO response = new ResponseDTO();
		response.setId(id);
		response.setMessage("Orden creada correctamente");
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/orders", produces = "application/json")
	public ResponseEntity<List<OrderResponseDTO>> getAll() {
		List<OrderResponseDTO> ordersResponse = this.getOrderServiceImpl().getAll();
		return new ResponseEntity<List<OrderResponseDTO>>(ordersResponse, HttpStatus.OK);
	}
	
	@GetMapping(path = "/order/{code}", produces = "application/json")
	public ResponseEntity<OrderResponseDTO> getByCode(@PathVariable(name = "code") Long code) {
		OrderResponseDTO ordersResponse = this.getOrderServiceImpl().getByCode(code);
		return new ResponseEntity<OrderResponseDTO>(ordersResponse, HttpStatus.OK);
	}
}
