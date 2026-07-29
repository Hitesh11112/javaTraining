package com.coforge.Day_03_07_26_Prj;

public class Honda implements Car{

	@Override
	public void start() {
		System.out.println("Car started Manully");
	}

	@Override
	public void stop() {
		System.out.println("Car stopped Manully");
	}

}
