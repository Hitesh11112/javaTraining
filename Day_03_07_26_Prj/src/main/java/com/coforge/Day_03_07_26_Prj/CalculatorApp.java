package com.coforge.Day_03_07_26_Prj;

public class CalculatorApp implements SimpleCalculator,ScientificCalculator{

	public static void main(String[] args) {
		
		CalculatorApp ca=new CalculatorApp();
		ca.add(5, 6);
		ca.sub(7, 8);
		ca.mul(5,9);
		ca.div(25,5);
		
		//write code to call scientific calculator methods
		System.out.println(ca.power(4, 3));
		System.out.println(ca.squareRoot(25));
		System.out.println(ca.logValue(10));
		
	}

	@Override
	public void add(int a, int b) {
		System.out.println(a+b);
		
	}

	@Override
	public void sub(int a, int b) {
		System.out.println(a-b);
		
	}

	@Override
	public void mul(int a, int b) {
		System.out.println(a*b);
	}

	@Override
	public void div(int a, int b) {
		System.out.println(a/b);
	}

	@Override
	public double power(double a, double b) {
		
		return Math.pow(a, b);
	}

	@Override
	public double squareRoot(double m) {
		
		return Math.sqrt(m);
	}

	@Override
	public double logValue(double m) {
		
		return Math.log(m);
	}

}
