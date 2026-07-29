package com.coforge.day_06July;

import java.util.*;

public class SetMain {
	public static void main(String[] args) {
		HashSet<Integer> st = new HashSet<>();
		st.add(67);
		st.add(45);
		st.add(1);
		st.add(89);
		st.add(12);
		st.add(56);
		st.add(12);//no insertion order, no duplicates 
		st.add(null);
		System.out.println(st);
		
//		st.add(null); //multiple null values not possible
		HashSet<Integer> st1 = new HashSet<>();
		st1.add(65);
		st1.add(85);
		st1.add(13);
		st1.add(1);
		st1.add(89);
		st1.add(121);
		st1.add(56);
		st1.add(12);
		System.out.println(st1);
		
		st.retainAll(st1);
		System.out.println(st);
		
		Object[] obj = st1.toArray();
		Integer[] arr1= (Integer[])obj;
		for(int i : arr1) System.out.println(i);
		
		System.out.println("-----------------------------");
		
		Integer[] arr2= st.toArray(new Integer[0]);
		for(int i : arr2) System.out.println(i);
		System.out.println("-----------------------------");
		
		
		// iterator()
        System.out.println("\nUsing Iterator:");
        Iterator<Integer> itr = st.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("------------------------");
        
        //cloned
        HashSet<Integer> cloned = (HashSet<Integer>) st.clone();
        System.out.println("Cloned Copy " + cloned);
        System.out.println("------------------------");
        
        // clear()
        cloned.clear();
	}
}
