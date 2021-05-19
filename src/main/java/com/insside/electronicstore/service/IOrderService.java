package com.insside.electronicstore.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.insside.electronicstore.dto.OrderDTO;
import com.insside.electronicstore.dto.OrderResponseDTO;

public interface IOrderService {
		
	@Transactional(readOnly = false)
	public Long save(OrderDTO clientDTO);
	
	@Transactional(readOnly = true)
	public List<OrderResponseDTO> getAll();

	@Transactional(readOnly = true)
	public OrderResponseDTO getByCode(Long code);
	

}
