package com.coforge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coforge.beans.Order;

public class App {
	public static void main(String[] args) { 
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("hello-bean.xml");
//		Hello h = (Hello) context.getBean("hello");
//		h.sayHello();
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("item-bean.xml");
//		Item i1 = (Item) context.getBean("item");
//		System.out.println(i1);
//		
//		Item i2 = (Item) context.getBean("item1");
//		System.out.println(i2);		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("order-item-bean.xml");
		Order order = (Order) context.getBean("ord");
		System.out.println(order);
		
	}
}
