package com.coforge.Day_07_07_26_Exception;

import java.util.*;

@FunctionalInterface
interface Hello{
	public void sayHello();
}


public class Main {
	
	public static void main(String[] args) {
		
		Hello h = ()-> {
			System.out.println("Hello........");
		};
		h.sayHello();
		
		Integer arr[] = {1,2,3,4,5,6};
		List<Integer> list = Arrays.asList(arr);
		
		list.forEach((ele)->System.out.print(ele + " "));
		
	}
}
