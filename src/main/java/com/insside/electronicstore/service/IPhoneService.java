package com.insside.electronicstore.service;


import org.springframework.transaction.annotation.Transactional;

import com.insside.electronicstore.dto.PhoneDTO;

public interface IPhoneService {

	@Transactional(readOnly = false)
	public Long save(PhoneDTO phoneDTO);
	
	@Transactional(readOnly = false)
	public Long update(PhoneDTO phoneDTO, Long id);

	@Transactional(readOnly = false) 
	public void delete(Long id);

}
