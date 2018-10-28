package com.microservice.demoordersservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	private OrderRepository repository;

	@GetMapping("/order/orderId/{orderId}")
	public OrderEntity user(@PathVariable String orderId) {
		return repository.findByOrderId(orderId);
	}
}
