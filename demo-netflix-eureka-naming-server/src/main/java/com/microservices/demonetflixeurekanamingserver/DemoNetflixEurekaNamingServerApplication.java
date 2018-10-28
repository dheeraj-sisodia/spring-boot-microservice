package com.microservices.demonetflixeurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoNetflixEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoNetflixEurekaNamingServerApplication.class, args);
	}
}
