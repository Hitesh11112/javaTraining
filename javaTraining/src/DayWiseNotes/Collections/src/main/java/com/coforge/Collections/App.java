package com.coforge.Collections;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
    	
    	ArrayList arr = new ArrayList();
    	arr.add(10);
    	arr.add("Hitesh");
    	arr.add(54.78f);
    	arr.add(10);
    	arr.add(10);
    	arr.add(10);
    	arr.add(true);
    	arr.add(null);
    	
    	int n = arr.size();
    	for(int idx = 0; idx < n; ++idx) {
    		System.out.println(arr.get(idx));
    	}
    }
}
