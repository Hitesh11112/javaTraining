package com.coforge.day_06July;

import java.util.*;

public class PriorityQueueMain {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(47);
		pq.add(27);
		pq.add(222);
		pq.add(1);
		pq.add(37);
		pq.add(77);
		System.out.println(pq.poll());
		System.out.println(pq);
		
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(89);
		dq.add(67);
		dq.addLast(100);
		dq.addFirst(01);
		dq.add(29);
		dq.offerFirst(88); //return boolean
		
		System.out.println(dq);
	}
}
