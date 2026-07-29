package com.coforge.Day_03_07_26_Prj;

public interface PetrolCar {
	
	public default void provideAc() {
		System.out.println("Petrol provides normal AC");
	}
}
