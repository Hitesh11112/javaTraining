package com.coforge.day_06July;

import java.util.*;

public class TreeMapMain {
	public static void main(String[] args) {
		TreeMap<Integer, Product> mp = new TreeMap<Integer,Product>();
		
		mp.put(101, new Product(101, "Laptop", 55000.00, 10));
		mp.put(102, new Product(102, "Mouse", 750.00, 50));
		mp.put(103, new Product(103, "Keyboard", 1200.00, 30));
		mp.put(104, new Product(104, "Monitor", 15000.00, 15));
		mp.put(105, new Product(105, "Printer", 9000.00, 8));
		mp.put(106, new Product(106, "Speaker", 2500.00, 20));
		mp.put(107, new Product(107, "Headphones", 1800.00, 25));
		mp.put(108, new Product(108, "Webcam", 3200.00, 12));
		mp.put(109, new Product(109, "SSD", 6500.00, 18));
		mp.put(110, new Product(110, "UPS", 4800.00, 6));
		
//		for (Map.Entry<Integer, Product> entry : mp.entrySet()) {
//		    System.out.println(entry.getKey() + " -> " + entry.getValue());
//		}
		mp.forEach((key, value) -> System.out.println(key + " -> " + value));
		Set<Integer> st = mp.descendingKeySet();
		
		for(Integer s : st) System.out.println(s);
		// complete remaining methods 
	}
}
