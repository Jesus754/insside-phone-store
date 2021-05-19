package com.insside.electronicstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insside.electronicstore.model.entity.Phone;

@Repository
public interface IPhoneRepository extends JpaRepository<Phone, Long>{
	
	public Phone getByCode(String code);

}
