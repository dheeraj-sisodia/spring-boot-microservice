package com.microservice.demouserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserRepository repository;
	@Autowired
	private UserOrderProxy orderProxy;

	@GetMapping("/user/userId/{userId}")
	public UserEntity user(@PathVariable String userId) {
		UserEntity user = repository.findByUserId(userId);
		user.setOrders(orderProxy.retrieveOrderListforUser(userId));
		return user;
	}
}
