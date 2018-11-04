package com.springbootcassandra.demo.cassandra;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private CustomerRepository repository;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return (List<Customer>) repository.findAll();
	}

	@PostMapping("/customer")
	private void saveCustomer(@RequestBody Customer customer) {
		customer.setId(UUID.randomUUID());
		repository.save(customer);
	}
}
