package com.insside.electronicstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insside.electronicstore.config.exception.BadRequestException;
import com.insside.electronicstore.config.exception.NotFoundException;
import com.insside.electronicstore.dto.ClientDTO;
import com.insside.electronicstore.model.entity.Client;
import com.insside.electronicstore.model.repository.IClientRepository;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientRepository clientRepository;
	
	@Autowired
	private ITranslatorService TranslatorService;

	public IClientRepository getClientRepository() {
		return this.clientRepository;
	}

	public void setPhoneRepository(IClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	

	public ITranslatorService getTranslatorService() {
		return TranslatorService;
	}

	public void setTranslatorService(ITranslatorService translatorService) {
		TranslatorService = translatorService;
	}

	@Override
	public Long save(ClientDTO clientDTO) {
		Client clientEntity = this.getClientRepository().getByDni(clientDTO.getDni());
		if (clientEntity != null) 
			throw new BadRequestException("El cliente con dni " + clientDTO.getDni() + " ya existe");
		clientEntity = this.getTranslatorService().clientDTOtoEntity(clientDTO);
		return this.getClientRepository().save(clientEntity).getId();
	}

	@Override
	public Long update(ClientDTO clientDTO, Long id) {
		Optional<Client> oClient = this.getClientRepository().findById(id);
		if (oClient.isEmpty()) 
			throw new NotFoundException("El cliente con id " + id + " no existe");
		Client clientEntity = oClient.get();
		clientEntity.setAddress(clientDTO.getAddress());
		clientEntity.setDni(clientDTO.getDni());
		clientEntity.setLastName(clientDTO.getLastName());
		clientEntity.setName(clientDTO.getName());
		clientEntity.setPhoneNumber(clientDTO.getPhoneNumber());
		return this.getClientRepository().save(clientEntity).getId();
	}

	@Override
	public void delete(Long id) {
		Optional<Client> oClient = this.getClientRepository().findById(id);
		if (oClient.isEmpty())
			throw new NotFoundException("El cliente con id " + id + " no existe");
		this.getClientRepository().deleteById(id);
	}

	
	
}
