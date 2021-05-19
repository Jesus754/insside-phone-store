package com.insside.electronicstore.service;


import org.springframework.transaction.annotation.Transactional;

import com.insside.electronicstore.dto.ClientDTO;
public interface IClientService {

	@Transactional(readOnly = false)
	public Long save(ClientDTO clientDTO);

	@Transactional(readOnly = false)
	public Long update(ClientDTO clientDTO, Long id);

	@Transactional(readOnly = false)
	void delete(Long id);
	

}
