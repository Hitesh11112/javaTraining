package com.coforge;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coforge.beans.HelloBean;
import com.coforge.config.SpringConfig;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        HelloBean h = (HelloBean)context.getBean("hello");
        h.sayHello();
        context.close();
    }
}