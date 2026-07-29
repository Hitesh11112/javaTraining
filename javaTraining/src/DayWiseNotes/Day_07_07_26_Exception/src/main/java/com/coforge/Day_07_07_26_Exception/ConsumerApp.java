package com.coforge.Day_07_07_26_Exception;

import java.util.Arrays;
import java.util.List;


public class ConsumerApp {
	public static void main(String[] args) {
		Integer arr[] = {1,2,3,4,5,6,7,8,9,10};
		List<Integer> list = Arrays.asList(arr);
		
//		Consumer<Integer> consumer = (ele)->System.out.print(ele + " ");
//		consumer.accept(25);
		
		list.forEach(ele->System.out.print(ele + " "));
	}
}
