package Day_2July.AreaPerimeter;

public class Circle extends Shape {
	 
    private double radius;
 
    public Circle() {
        this.radius = 1;
    }
 
    public Circle(double radius) {
        this.radius = radius;
    }
 
    @Override
    void area() {
        System.out.println("Area of Circle = " + (3.14 * radius * radius));
    }
 
    @Override
    void perimeter() {
        System.out.println("Perimeter of Circle = " + (2 * Math.PI * radius));
    }
}