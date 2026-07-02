package com.Shape;

public class Circle extends Shape {
	 
    private double radius;
 
    // Non-Parameterized Constructor
    public Circle() {
        this.radius = 1;
    }
 
    // Parameterized Constructor
    public Circle(double radius) {
        this.radius = radius;
    }
 
    @Override
    void area() {
        System.out.println("Area of Circle = " + (Math.PI * radius * radius));
    }
 
    @Override
    void perimeter() {
        System.out.println("Perimeter of Circle = " + (2 * Math.PI * radius));
    }
}