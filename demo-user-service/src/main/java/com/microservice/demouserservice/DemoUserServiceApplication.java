package com.microservice.demouserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.microservice.demouserservice")
@EnableDiscoveryClient
public class DemoUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoUserServiceApplication.class, args);
	}
}
