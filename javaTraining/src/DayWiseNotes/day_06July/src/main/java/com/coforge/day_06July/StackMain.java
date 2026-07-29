package com.coforge.day_06July;

import java.util.Stack;

public class StackMain {
	public static void main(String[] arg) {
		Stack<Integer> st = new Stack<>();
		for(int idx = 1; idx <= 10; ++idx) {
			st.push((int)(Math.round(Math.random()*100)));
		}
		System.out.println(st);
		System.out.println(st.search(97));
	}
}
