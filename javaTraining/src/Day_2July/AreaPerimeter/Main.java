package Day_2July.AreaPerimeter;

public class Main {
	public static void main(String[] args) {
		Shape sh1 = new Square(4);
        sh1.area();
        sh1.perimeter();
 
        System.out.println();
 
        Shape sh2 = new Circle(5);
        sh2.area();
        sh2.perimeter();
 
        System.out.println();
 
        Shape sh3 = new Rectangle(10, 5);
        sh3.area();
        sh3.perimeter();
 
        System.out.println();
 
        // Non-Parameterized Constructors
 
        Shape sh4 = new Square();
        sh4.area();
        sh4.perimeter();
 
        System.out.println();
 
        Shape sh5 = new Circle();
        sh5.area();
        sh5.perimeter();
 
        System.out.println();
 
        Shape sh6 = new Rectangle();
        sh6.area();
        sh6.perimeter();
	}
}
