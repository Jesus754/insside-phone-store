package com.insside.electronicstore.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insside.electronicstore.model.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Long>{

	public Order findByCode(Long code);

}
