package com.insside.electronicstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insside.electronicstore.config.exception.BadRequestException;
import com.insside.electronicstore.config.exception.NotFoundException;
import com.insside.electronicstore.dto.OrderDTO;
import com.insside.electronicstore.dto.OrderResponseDTO;
import com.insside.electronicstore.dto.PhoneDTO;
import com.insside.electronicstore.model.entity.Client;
import com.insside.electronicstore.model.entity.Order;
import com.insside.electronicstore.model.entity.Phone;
import com.insside.electronicstore.model.repository.IClientRepository;
import com.insside.electronicstore.model.repository.IOrderRepository;
import com.insside.electronicstore.model.repository.IPhoneRepository;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired 
	private IClientRepository clientRepository;
	
	@Autowired 
	private IOrderRepository orderRepository;
	
	@Autowired 
	private ITranslatorService traslatorServiceImpl;
	
	@Autowired
	private IPhoneRepository phoneRepository;
	
	
	
	public IPhoneRepository getPhoneRepository() {
		return phoneRepository;
	}

	public void setPhoneRepository(IPhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
	}

	public IOrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(IOrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public ITranslatorService getTraslatorServiceImpl() {
		return traslatorServiceImpl;
	}

	public void setTraslatorServiceImpl(ITranslatorService traslatorServiceImpl) {
		this.traslatorServiceImpl = traslatorServiceImpl;
	}

	public IClientRepository getClientRepository() {
		return clientRepository;
	}

	public void setClientRepository(IClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Long save(OrderDTO orderDTO){
		Order orderEntity = this.getOrderRepository().findByCode(orderDTO.getCode());
		
		if (orderEntity != null) 
			throw new BadRequestException("La orden con codigo " + orderDTO.getCode() + " ya existe");
		
		Client clientEntity  = this.getClientRepository().getByDni(orderDTO.getClient().getDni());
		
		if (clientEntity == null) {
			clientEntity = this.getTraslatorServiceImpl().clientDTOtoEntity(orderDTO.getClient());
			this.getClientRepository().save(clientEntity);
		}
		orderEntity = this.getTraslatorServiceImpl().orderDTOtoEntity(orderDTO, clientEntity);
		List<Phone> phones = new ArrayList<Phone>(); 
		

		for (PhoneDTO phoneDTO : orderDTO.getPhones()) {
			Phone phoneEntitiy = this.getPhoneRepository().getByCode(phoneDTO.getCode());
			if (phoneEntitiy == null)
				throw new NotFoundException("El telefono con codigo " + phoneDTO.getCode() + " no existe");
			phones.add(phoneEntitiy);
		}
		orderEntity.setCode(orderDTO.getCode());
		orderEntity.setPhones(phones);
		return this.getOrderRepository().save(orderEntity).getId();
			
	}

	@Override
	public List<OrderResponseDTO> getAll(){
		List<Order> orders = this.getOrderRepository().findAll();
		return this.traslatorServiceImpl.listOrderToListOrderDTO(orders);
	}

	@Override
	public OrderResponseDTO getByCode(Long code){
		Order orderEntity = this.getOrderRepository().findByCode(code);
		if (orderEntity == null) {
			throw new NotFoundException("La orden con codigo " + code + " no existe");
		}
		OrderResponseDTO orderResponseDTO = this.getTraslatorServiceImpl().orderEntityToDTO(orderEntity);
		return orderResponseDTO;
	}
	
}
