package com.naughtyzombie.boilerplate.springreactboilerplate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/auth/hello")
	public String sayHi()
	{
		return "skap aj ty";
	}
}
	