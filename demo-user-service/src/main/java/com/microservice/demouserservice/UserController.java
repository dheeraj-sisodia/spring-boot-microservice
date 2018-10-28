package com.microservice.demouserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserRepository repository;

	@GetMapping("/user/userId/{userId}")
	public UserEntity user(@PathVariable String userId) {
		return repository.findByUserId(userId);
	}
}
