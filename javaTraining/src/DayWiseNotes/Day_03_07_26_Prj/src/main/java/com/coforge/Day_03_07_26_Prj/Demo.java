package com.coforge.Day_03_07_26_Prj;

public final class Demo { //extends not possible 
	
	final static String name ="hitesh";
	public final String sayHello(String name) { //override not possible 
		return "Hello" + name;
	}
	public String getName() {
		return name;
	}
}
