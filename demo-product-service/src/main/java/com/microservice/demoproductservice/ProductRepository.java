package com.microservice.demoproductservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	public ProductEntity findByProductId(String productId);
}
