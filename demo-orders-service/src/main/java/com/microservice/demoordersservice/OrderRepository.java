package com.microservice.demoordersservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	public OrderEntity findByOrderId(String orderId);

	public List<OrderEntity> findByUserId(String userId);
}
