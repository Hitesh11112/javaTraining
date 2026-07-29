package com.coforge.Day_07_07_26_Exception;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateApp {

	public static void main(String[] args) {
		
		Integer[] arr = {34,12,23,42,43,25,32,43,54,12};
		List<Integer> list = Arrays.asList(arr);
			
		Predicate<Integer> predicate = (n)-> n%2==0;
		for(Integer n : list) {
			if(predicate.test(n)) {
				System.out.println(n);
			}
		}
		System.out.println("-----------");
		predicate=(n)->n>30;
		for(Integer n : list) {
			if(predicate.test(n)) {
				System.out.println(n + " ");
			}
		}
		System.out.println("-----------");
		
		//list of string or names and print only 
		//those names start with s
		String[] names = {"Hitesh", "Patwal","sram","shitesh"};
		List<String> namesList = Arrays.asList(names);
		Predicate<String> predicate1 = (n)-> n.charAt(0)=='s';
		for(String name : namesList) {
			if(predicate1.test(name)) {
				System.out.println(name);
			}
		}
		//filter on streams will take predicate as a parameter

	}

}
