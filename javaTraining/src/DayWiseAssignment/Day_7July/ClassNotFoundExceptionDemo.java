/*
 * ClassNotFoundException
 * Thrown when trying to load a class by name using Class.forName(),
 * and that class doesn't exist anywhere on the class path.
 * (No JDBC driver loading involved - just a made-up class name.)
 */

package DayWiseAssignment.Day_7July;

public class ClassNotFoundExceptionDemo {
	
	public static void loadClass() {
        try {
            Class.forName("com.student.NonExistentClass"); // no such class exists
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }
	
}
