package com.coforge.Day_07_07_26_Exception;

public class CalculatorApp {
	
	public static void main(String[] args) {
//		CalculatorInterfaceClass c=() ->{
//			int a = 10, b = 5;
//			System.out.println(a/b);
//		};
//		CalculatorApp c = new CalculatorApp();
//		System.out.println(s.add(2,2));
//		CalculatorInterfaceClass c = (a,b) -> a+b;
//		System.out.println(c.add(5,6));
		
//		CalculatorInterfaceClass c = () ->{
//			int a = 10, b = 5;
//			return a-b;
//		};
//		System.out.println(c.sub());
		
		CalculatorInterfaceClass c = (a,b)-> {
			System.out.println(a*b);
		};
		c.mul(2, 2);
	}

//	@Override
//	public int add(int a, int b) {
//		return a+b;
//	}

//	@Override
//	public int sub() {
//		int a = 67, b= 3; 
//		return a-b;
//	}
	
//	@Override
//	public void mul(int a, int b) {
//		System.out.println(a*b);
//	}

//	@Override
//	public void div() {
//		int a = 12;
//		int b = 10;
//		System.out.println(a/b);
//	}
}
