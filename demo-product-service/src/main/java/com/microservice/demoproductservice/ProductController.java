package com.microservice.demoproductservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductRepository repository;

	@GetMapping("/product/productId/{productId}")
	public ProductEntity user(@PathVariable String productId) {
		return repository.findByProductId(productId);
	}
}
