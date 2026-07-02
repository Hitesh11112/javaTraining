package Fraction;

public class SimpleCalculator {
	
	public int add(int a, int b) {
		return a+b;
	}
	public int add(int a, int b, int c) {
		return a+b+c;
	}
	public double add(double d1, double d2) {
		return d1+d2;
	}
	
	public static void main(String[] args) {
		SimpleCalculator sc = new SimpleCalculator();
		System.out.println(sc.add(1, 2));		
		System.out.println(sc.add(1, 2, 3));		
		System.out.println(sc.add(10.0, 20.0));		
	}
}
