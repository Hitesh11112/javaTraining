package com.coforge;

import java.util.ArrayList;
import java.util.Collections;

public class ItemsMainClass {
	public static void main(String[] args) {
		
		ArrayList<Item> itemList=new ArrayList<Item>();
		
		Item laptop=new Item("Dell",12345,65000);
		Item mouse=new Item("Logitech",6754,900);
		Item printer=new Item("Canon",5432,5000);
		
		itemList.add(laptop);
		itemList.add(mouse);
		itemList.add(printer);
		
		System.out.println(itemList);
		
		Collections.sort(itemList);//not simple collection, collection of objects
		//can not apply naturally sorting order,item contains multiple properties
		//it cant understand on which property sort should be applied
		
		//comparable,comparator interfaces has to be implemented
		
		for(Item i:itemList)
			System.out.println(i);
		
		
		
		
		
	}

}
