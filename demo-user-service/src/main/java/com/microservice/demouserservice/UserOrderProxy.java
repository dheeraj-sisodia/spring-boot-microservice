package com.microservice.demouserservice;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="order-service", url="localhost:8200")
//@FeignClient(name="order-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name = "order-service")
public interface UserOrderProxy {
	//@GetMapping("/order/userId/{userId}")
	@GetMapping("/order-service/order/userId/{userId}")
	public List<UserOrder> retrieveOrderListforUser(@PathVariable("userId") String userId);
}
