package com.coforge.Day_03_07_26_Prj;

public interface ElectricCar {
	
	public default void provideAc() {
		System.out.println("Electric Provides Smart AC");
	}
}
