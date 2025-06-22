package com.circuitbreaker.service1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowWorldController {

	@RequestMapping("/")
	public String sayHello() {
		return "Hello World 1";
	}

}
