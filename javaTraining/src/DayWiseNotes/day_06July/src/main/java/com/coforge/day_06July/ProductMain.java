package com.coforge.day_06July;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ProductMain {
	public static void main(String[] args) {
		
//		TreeSet<Product> ts = new TreeSet<Product>();
//
//		ts.add(new Product(101, "Laptop", 65000, 5));
//		ts.add(new Product(102, "Mouse", 700, 50));
//		ts.add(new Product(103, "Keyboard", 1200, 30));
//		ts.add(new Product(104, "Monitor", 15000, 10));
//		ts.add(new Product(105, "Printer", 9000, 8));
//		ts.add(new Product(106, "Scanner", 7500, 6));
//		ts.add(new Product(107, "Webcam", 2500, 20));
//		ts.add(new Product(108, "Speaker", 3500, 15));
//		ts.add(new Product(109, "Hard Disk", 5000, 12));
//		ts.add(new Product(110, "SSD", 8000, 18));
//		
//		for(Product p : ts) System.out.println(p);
//		//tree set under =-> sorted set 
//		//natural sorting single element if present 
//		System.out.println(ts); // error 
		
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(67);
		treeSet.add(34);
		treeSet.add(90);
		treeSet.add(31);
		
		System.out.println(treeSet);
		
		Set<Integer> set = treeSet.descendingSet();
		System.out.println(set);
		
		Iterator<Integer> itr = treeSet.descendingIterator();
		while(itr.hasNext()) System.out.println(itr.next());
		
		System.out.println(treeSet.pollFirst());
		
		System.out.println(treeSet.ceiling(90)); // >=
		System.out.println(treeSet.higher(90));  // > 
		System.out.println(treeSet.floor(90));   // <=
		System.out.println(treeSet.lower(90));   // < 
	
		
	}
}
