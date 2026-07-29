package com.coforge.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	@RequestMapping("/name")
	public String printName( ) {
		return "My name is Hitesh Patwal";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
}
