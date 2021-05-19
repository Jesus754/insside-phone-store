package com.insside.electronicstore.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.insside.electronicstore.dto.ClientDTO;
import com.insside.electronicstore.dto.OrderDTO;
import com.insside.electronicstore.dto.OrderResponseDTO;
import com.insside.electronicstore.dto.PhoneDTO;
import com.insside.electronicstore.model.entity.Client;
import com.insside.electronicstore.model.entity.Order;
import com.insside.electronicstore.model.entity.Phone;

@Service
public class TranslatorService implements ITranslatorService{

	@Override
	public Phone phoneDTOtoEntity(PhoneDTO phoneDTO) {
		Phone phoneEntity = new Phone();
		phoneEntity.setCode(phoneDTO.getCode());
		phoneEntity.setBrand(phoneDTO.getBrand());
		phoneEntity.setModel(phoneDTO.getModel());
		phoneEntity.setPrice(phoneDTO.getPrice());
		return phoneEntity;
	}
	
	public PhoneDTO phoneEntitytoDTO(Phone phoneEntity) {
		PhoneDTO phoneDTO = new PhoneDTO();
		phoneDTO.setCode(phoneEntity.getCode());
		phoneDTO.setBrand(phoneEntity.getBrand());
		phoneDTO.setModel(phoneEntity.getModel());
		phoneDTO.setPrice(phoneEntity.getPrice());
		return phoneDTO;
	}

	@Override
	public Client clientDTOtoEntity(ClientDTO clientDTO) {
		Client clientEntity = new Client();
		clientEntity.setAddress(clientDTO.getAddress());
		clientEntity.setDni(clientDTO.getDni());
		clientEntity.setLastName(clientDTO.getLastName());
		clientEntity.setName(clientDTO.getName());
		clientEntity.setPhoneNumber(clientDTO.getPhoneNumber());
		return clientEntity;
	}

	@Override
	public Order orderDTOtoEntity(OrderDTO orderDTO, Client clientEntity) {
		Order orderEntity = new Order();
		orderEntity.setDate(new Date());
		orderEntity.setTotal(0L);
		orderEntity.setClient(clientEntity);
		return orderEntity;
	}

	@Override
	public List<OrderResponseDTO> listOrderToListOrderDTO(List<Order> orders) {
		List<OrderResponseDTO> ordersDTO = new ArrayList<OrderResponseDTO>();
		for (Order order : orders) {
			ordersDTO.add(this.orderEntityToDTO(order));
		}
		return ordersDTO;
	}

	@Override
	public ClientDTO clientEntityToDTO(Client clientEntity) {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setAddress(clientEntity.getAddress());
		clientDTO.setDni(clientEntity.getDni());
		clientDTO.setLastName(clientEntity.getLastName());
		clientDTO.setName(clientEntity.getName());
		clientDTO.setPhoneNumber(clientEntity.getPhoneNumber());
		return clientDTO;
	}
	
	
	@Override
	public List<PhoneDTO> phonesEntitesToPhonesDTO(List<Phone> phonesEntities) {
		List<PhoneDTO> phonesDTO = new ArrayList<PhoneDTO>();
		for (Phone phoneEntity : phonesEntities) {
			phonesDTO.add(this.phoneEntitytoDTO(phoneEntity));
		}
		return phonesDTO;
	}

	@Override
	public OrderResponseDTO orderEntityToDTO(Order orderEntity) {
		OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
		orderResponseDTO.setClient(this.clientEntityToDTO(orderEntity.getClient()));
		orderResponseDTO.setCode(orderEntity.getCode());
		orderResponseDTO.setDate(orderEntity.getDate());
		orderResponseDTO.setPhones(this.phonesEntitesToPhonesDTO(orderEntity.getPhones()));
		orderResponseDTO.setTotal(0L);
		return orderResponseDTO;
	}

}

