package javaOnlineMeeting.Collections.Day03;

import java.util.ArrayList;
import java.util.Collections;

public class ItemsMainClass {
	public static void main(String[] args) {
		ArrayList<Item> itemList = new ArrayList<Item>();
		Item laptop = new Item("Dell",1234,65000);
		Item mouse = new Item("LogiTech",1431,434);
		Item printer = new Item("canon",1431,83434);
		
		itemList.add(laptop);
		itemList.add(mouse);
		itemList.add(printer);
		
		System.out.println(itemList);
		
		Collections.sort(itemList);
		
		for(Item i: itemList) 
			System.out.println(i);
	}
}
