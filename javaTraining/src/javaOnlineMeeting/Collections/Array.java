package javaOnlineMeeting.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class Array {	
	public static void main(String[] args) {
    	
//	    	ArrayList arr = new ArrayList();
//	    	arr.add(10);
//	    	arr.add("Hitesh");
//	    	arr.add(54.78f);
//	    	arr.add(10);
//	    	arr.add(10);
//	    	arr.add(10);
//	    	arr.add(true);
//	    	arr.add(null);
//	    	
//	    	int n = arr.size();
//	    	for(int idx = 0; idx < n; ++idx) {
//	    		System.out.println(arr.get(idx));
//	    	}
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(34);
		arr.add(31);
		arr.add(33);
		arr.add(12);
		
		arr.add(null);
		arr.add(null);
		arr.add(null);
		
		
		//add at a specific position
		arr.add(3,99);
//		arr.addFirst(001);
//		arr.addLast(1000);
//		for(Integer ele : arr) {
//			System.out.println(ele);
//		}
	
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(2);
		arr2.addFirst(10);
		arr2.add(4);
		arr2.add(10);
		arr2.add(6);
		arr2.add(9);
		
		System.out.println("******************");		
		
		for(int idx = 0; idx < arr2.size(); ++idx) {
			System.out.println(arr2.get(idx));
		}
		System.out.println("******************");
		
		System.out.println(arr2.contains(1));
		System.out.println("******************");
		
		System.out.println(arr2.remove(0));
		System.out.println("******************");
		
		Integer rem = 4;
		System.out.println(arr2.remove(rem));
		System.out.println("******************");
		
		System.out.println(arr2.remove(Integer.valueOf(0)));
		System.out.println(arr2.removeAll(arr));
		
		for(Integer ele : arr2) {
			System.out.println(ele);
		}
		System.out.println("******************");
		
		arr2.forEach(ele -> System.out.println(ele));
		System.out.println("******************");
		
		arr2.reversed().forEach(ele -> System.out.println(ele + " "));
		System.out.println("******************");
		
//		iterator
		Iterator<Integer> itr = arr2.iterator();
		
		while(itr.hasNext()) {
			int value = itr.next();
			if(value == 31) itr.remove();
			System.out.println(itr.next());
		}
		
		
		ListIterator<Integer> itr1 = arr2.listIterator();
		while(itr1.hasNext()) System.out.println(itr1.next());
		System.out.println("******************");
		
		while(itr1.hasPrevious()) System.out.println(itr1.previous()); 
		while(itr1.hasNext()) System.out.println(itr1.next());
		System.out.println("******************");
		
		System.out.println("Clone ArrayList");
		ArrayList<Integer> cloned = (ArrayList<Integer>) arr2.clone();
		System.out.println(arr2.hashCode());
		System.out.println(cloned.hashCode());
		
		arr2.add(500);
		System.out.println("******************");
		
		Collections.sort(arr2);
		
    }
}
