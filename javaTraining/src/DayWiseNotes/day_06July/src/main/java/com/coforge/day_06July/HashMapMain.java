package com.coforge.day_06July;

import java.util.*;


public class HashMapMain {
	public static void main(String[] args) {
		HashMap<Integer,String> mp = new HashMap<>();
		mp.put(1,"apple");
		mp.put(32,"orange");
		mp.put(5,"banana");
		mp.put(65, "watermelon");
		
		mp.put(5, "pineapple");
		System.out.println(mp);
		
		mp.put(7,"orange");
		System.out.println(mp);
		System.out.println("________________________");
		System.out.println(mp.keySet());
		System.out.println(mp.values());
		System.out.println(mp.entrySet());
		System.out.println(mp.get(77)); // null 
		
		System.out.println("________________________");
		
		System.out.println(mp.containsKey(65));
		System.out.println(mp.containsValue("guava"));  //false
		System.out.println(mp.getOrDefault(9,"No fruit"));
		mp.put(9,"No fruit");
		System.out.println(mp);
		mp.replace(9, "dragon fruit");
		System.out.println(mp);
		mp.put(null, "abcd");
		System.out.println(mp);
		
		Set<Map.Entry<Integer,String>> entry = mp.entrySet();
		Iterator<Map.Entry<Integer, String>> itr = entry.iterator();
			
		while(itr.hasNext()) System.out.println(itr.next());
		
	}
}