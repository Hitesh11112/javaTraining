package com.coforge.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("hello")
public class HelloBean {
	
	public HelloBean()
	{
		System.out.println("1. Hello Bean Constructor called");
	}
	@PostConstruct
	public void init()
	{
		
		System.out.println("2. @PostConstruct init() called");
	}
	public void sayHello()
	{
		System.out.println("3. Hello....Hitesh");
	}
	@PreDestroy
	public void destroy()
	{
		
		System.out.println("4. @PerDestroy destroy() called");
		
	}
}