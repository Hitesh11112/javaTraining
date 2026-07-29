package com.coforge.day_06July;

import java.util.Enumeration;
import java.util.Vector;


public class VectorMain {
	public static void main(String[] args) {
		
		Vector<Integer> arr = new Vector<Integer>();
//		arr.add(56);
//		arr.add(67);
//		arr.add(78);
//		
		for(int idx = 1; idx <= 10; ++idx) {
			arr.add(idx);
		}
		
		System.out.println(arr);
		System.out.println(arr.capacity());
		
		arr.add(11);
//		arrayList is going to be increase by half of 
//		its original capacity when initial capacity gets exhausted 
		System.out.println(arr.capacity()); 
		
		///insert at index
		arr.add(0, 5);
		
		// firstElement()
        System.out.println("First Element: " + arr.firstElement());

        // lastElement()
        System.out.println("Last Element: " + arr.lastElement());
        
        //isEmpty()
        System.out.println("is vector empty: " + arr.isEmpty());
        
        //
        
        
        // contains()
        System.out.println("Contains 5: " + arr.contains(5));
        
        Vector<Integer> copy = (Vector<Integer>) arr.clone();
        System.out.println("Cloned Vector: " + copy);

        Vector<Integer>temp = new Vector<>(arr);
        temp.removeAllElements();
        System.out.println("After removeAllElements(): " + temp);
        
        
        //Enumeration
        Enumeration<Integer> enumeration = arr.elements();
        while(enumeration.hasMoreElements()) {
        	System.out.println(enumeration.nextElement());
        }
        //concurrent modification are not possible on 
        //enumeration like iterator
        
        
	}
}
