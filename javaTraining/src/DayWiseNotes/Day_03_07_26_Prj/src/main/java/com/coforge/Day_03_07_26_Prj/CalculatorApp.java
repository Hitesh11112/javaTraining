package com.coforge.Day_03_07_26_Prj;

public class CalculatorApp implements SimpleCalculator,ScientificCalculator{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorApp c = new CalculatorApp();
		c.add(1,2);
		c.mul(3,4);
		c.sub(8,1);
		c.div(5,6);
		
		System.out.println(c.power(4,3));
		System.out.println(c.logValue(10));
		System.out.println(c.squareRoot(25));

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
	public double logValue(double l) {
		return Math.log(l);
	}

}
