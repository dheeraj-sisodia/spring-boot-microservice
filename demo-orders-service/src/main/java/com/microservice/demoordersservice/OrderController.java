package com.microservice.demoordersservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	private OrderRepository repository;

	@GetMapping("/order/orderId/{orderId}")
	public OrderEntity orderbyOrderId(@PathVariable String orderId) {
		return repository.findByOrderId(orderId);
	}
	@GetMapping("/order/userId/{userId}")
	public List<OrderEntity> orderbyUserId(@PathVariable String userId) {
		return repository.findByUserId(userId);
	}
}
