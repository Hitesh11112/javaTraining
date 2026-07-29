package com.coforge.Day_03_07_26_Prj;

public class BMW implements Car{

	@Override
	public void start() {
		System.out.println("Car started remotely");
	}

	@Override
	public void stop() {
		System.out.println("Car stopped remotely");
	}
	@Override
	public void provideAC() {
		System.out.println("AC Provided");
	}
}
