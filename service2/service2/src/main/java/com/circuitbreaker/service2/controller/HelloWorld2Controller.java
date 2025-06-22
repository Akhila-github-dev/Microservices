package com.circuitbreaker.service2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class HelloWorld2Controller {
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	@CircuitBreaker(name = "companyBreaker", fallbackMethod = "testFallback")
	public String sayHello() {
		String message = restTemplate.getForObject("http://localhost:9191/", String.class);
		return message + "-->" + " Hello World 2";
	}

	public String testFallback(Exception e) {
		return "fallback method executed service1 is down plz try after some time";
	}

}
