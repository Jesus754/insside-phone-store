package com.insside.electronicstore.service;

import java.util.List;

import com.insside.electronicstore.dto.ClientDTO;
import com.insside.electronicstore.dto.OrderDTO;
import com.insside.electronicstore.dto.OrderResponseDTO;
import com.insside.electronicstore.dto.PhoneDTO;
import com.insside.electronicstore.model.entity.Client;
import com.insside.electronicstore.model.entity.Order;
import com.insside.electronicstore.model.entity.Phone;

public interface ITranslatorService {

	public Phone phoneDTOtoEntity(PhoneDTO phoneDTO);

	public Client clientDTOtoEntity(ClientDTO clientDTO);
	
	public ClientDTO clientEntityToDTO(Client client); 
	
	public Order orderDTOtoEntity(OrderDTO orderDTO, Client clientEntity);
	
	public OrderResponseDTO orderEntityToDTO(Order orderEntity);

	public List<OrderResponseDTO> listOrderToListOrderDTO(List<Order> order);

	public List<PhoneDTO> phonesEntitesToPhonesDTO(List<Phone> phonesEntities);
}
