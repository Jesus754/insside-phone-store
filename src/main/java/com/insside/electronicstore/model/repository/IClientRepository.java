package com.insside.electronicstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insside.electronicstore.model.entity.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long>{

	public Client getByDni(String dni);

}
