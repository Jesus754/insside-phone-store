package com.insside.electronicstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insside.electronicstore.config.exception.BadRequestException;
import com.insside.electronicstore.config.exception.NotFoundException;
import com.insside.electronicstore.dto.PhoneDTO;
import com.insside.electronicstore.model.entity.Phone;
import com.insside.electronicstore.model.repository.IPhoneRepository;

@Service
public class PhoneServiceImpl implements IPhoneService{

	@Autowired
	private IPhoneRepository phoneRepository;
	
	@Autowired
	private ITranslatorService TranslatorService;

	public IPhoneRepository getPhoneRepository() {
		return phoneRepository;
	}

	public void setPhoneRepository(IPhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
	}
	

	public ITranslatorService getTranslatorService() {
		return TranslatorService;
	}

	public void setTranslatorService(ITranslatorService translatorService) {
		TranslatorService = translatorService;
	}

	@Override
	public Long save(PhoneDTO phoneDTO){
		Phone phoneEntity = this.getPhoneRepository().getByCode(phoneDTO.getCode());
		if (phoneEntity != null) 
			throw new BadRequestException("El producto con codigo " + phoneDTO.getCode() + " ya existe");
		phoneEntity = this.getTranslatorService().phoneDTOtoEntity(phoneDTO);
		return this.getPhoneRepository().save(phoneEntity).getId();
	}

	@Override
	public Long update(PhoneDTO phoneDTO, Long id){
		Optional<Phone> phone = this.getPhoneRepository().findById(id);
		if (phone.isEmpty()) 
			throw new NotFoundException("El producto con id " + id + " no existe");
		Phone phoneEntity = phone.get();
		phoneEntity.setBrand(phoneDTO.getBrand());
		phoneEntity.setCode(phoneDTO.getCode());
		phoneEntity.setModel(phoneDTO.getModel());
		phoneEntity.setPrice(phoneDTO.getPrice());
		return this.getPhoneRepository().save(phoneEntity).getId();
	}

	@Override
	public void delete(Long id){
		Optional<Phone> oPhone = this.getPhoneRepository().findById(id);
		if (oPhone.isEmpty())
			throw new NotFoundException("El producto con id " + id + " no existe");
		this.getPhoneRepository().deleteById(id);
	}
	
	
	
	
	
	


	
	
}
