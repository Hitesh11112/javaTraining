package com.coforge.day_06July;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	LinkedList<String> list = new LinkedList<String>();
    	/*both iterator
    	 * Arraylist 
    		iterator
    		listitr
    	Linkedlist
    		
    		*/
    	list.add("Hitesh");
    	list.add("Amit");
    	list.add("Riya");
    	list.add("Riya");
    	System.out.println(list);
    	System.out.println("**********");
    	
    	list.addFirst("Pooja");
    	//addLast will return void when object added 
    	list.addLast("Keerti");
    	System.out.println(list);
    	
    	Iterator<String> itr = list.iterator();
    	
    	System.out.println("---------------");
    	
    	while(itr.hasNext()) {
    		System.out.print(itr.next() + " ");
    	}
    	System.out.println();

    	itr = list.descendingIterator();
    	while(itr.hasNext()) {
    		System.out.print(itr.next() + " ");
    	}
    	System.out.println();

    	System.out.println("---------------");
    	System.out.println(list.element()); //first element
    	
    	//offer return true if object added
    	System.out.println(list.offer("Moona"));
    	
    	System.out.print(list + " "); 
    	System.out.println();
    	
    	System.out.println("---------------");
    	System.out.println("Peek name " + list.peek());
    	System.out.println("Peek name " + list.peekLast());
    	
    	
//    	LinkedList<String> arr = list.reversed(); // it will return the reversed list but not modify
//    	System.out.println(arr);	
    	
    	// clone
    	LinkedList<String> cloneList = (LinkedList<String>) list.clone();
    	System.out.println("Clone: " + cloneList);

    	System.out.println("----------------");
    	

    	// push and pop (Stack operations)
    	list.push("StackTop");
    	System.out.println("After Push: " + list);

    	System.out.println("Pop: " + list.pop());
    	System.out.println("After Pop: " + list);

    	System.out.println("----------------");
    	
    	// clear
    	LinkedList<String> temp = new LinkedList<>(list);
    	temp.clear();
    	System.out.println("After Clear: " + temp);
    	
    	//contains
    	System.out.println(list.contains("Amit"));
    	System.out.println(list.contains("Hitesh"));
    	
    	//GetFirst
    	list.addFirst("Ok");
    	System.out.println(list.getFirst());
    	
    	//
    	System.out.println("----------------");
    	Collections.sort(list);
    	System.out.print(list + " ");
    	System.out.println();
    	
    	
    }
}
