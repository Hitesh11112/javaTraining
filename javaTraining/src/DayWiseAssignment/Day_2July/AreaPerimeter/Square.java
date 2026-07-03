package DayWiseAssignment.Day_2July.AreaPerimeter;

public class Square extends Shape {
	 
    private double side;
 
    // Non-Parameterized Constructor
    public Square() {
        this.side = 1;
    }
 
    // Parameterized Constructor
    public Square(double side) {
        this.side = side;
    }
 
    @Override
    void area() {
        System.out.println("Area of Square = " + (side * side));
    }
 
    @Override
    void perimeter() {
        System.out.println("Perimeter of Square = " + (4 * side));
    }
}