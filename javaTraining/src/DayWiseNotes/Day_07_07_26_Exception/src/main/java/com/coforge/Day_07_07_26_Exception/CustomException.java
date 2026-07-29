package com.coforge.Day_07_07_26_Exception;

public class CustomException {
	public static void main(String[] args) throws AgeNotSufficientException {
		Person p = new Person("Hitesh",18,"Dehradun");
		if(p.getAge() < 18) {
			throw new AgeNotSufficientException("Person Age is less than 18");
		}
		else {
			System.out.println("Person is eligible to case vote");
		}
	}
}
