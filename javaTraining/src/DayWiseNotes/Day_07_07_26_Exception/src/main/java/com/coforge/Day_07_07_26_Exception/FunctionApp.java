package com.coforge.Day_07_07_26_Exception;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionApp {
	
	public static void main(String[] args) {
		
		Function<Integer,Integer> function = (n)->n*5;
		System.out.println(function.apply(12));

		
		Integer[] arr = {34,12,23,42,43,25};
		List<Integer> list = Arrays.asList(arr);
		
		System.out.println("---------------->");
		for(Integer n : list) {
			System.out.println(function.apply(n));
		}
		
		System.out.println("---------------->");		
		String[] names = {"Hitesh", "Patwal","shitesh","sPatwal"};
		List<String> namesList = Arrays.asList(names);

		Function<String, String> function1 =(n)-> n.toUpperCase();

		for(String s : namesList) {
			System.out.println(function1.apply(s));
		}		
		System.out.println("---------------->");		
		
		//map on streams will take function as a parameter
	}
}
