package com.microservice.demoproductservice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductRepository repository;

	@PreAuthorize("#oauth2.hasScope('read')")
	@GetMapping("/product/productId/{productId}")
	public ProductEntity user(@PathVariable String productId) {
		return repository.findByProductId(productId);
	}

	@GetMapping("/product/productList")
	public ResponseEntity<Resource> productList(HttpServletRequest request) {
		String contentType = null;
		Resource resource = null;
		try {
			resource = new InputStreamResource(ExcelUtil.buildExcelDocument(repository.findAll()));
			contentType = "application/vnd.ms-excel";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "Products.xls" + "\"")
				.body(resource);

	}
}
