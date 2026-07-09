/*
 * ClassCastException
 * Thrown when trying to cast a student's name (String object) into
 * an incompatible type like Integer.
 */

package DayWiseAssignment.Day_7July;

public class ClassCastExceptionDemo {
	
	public static void castObject(Student s) {
        try {
            Object obj = s.getName(); // actually a String
            Integer id = (Integer) obj; // invalid cast
            System.out.println("ID: " + id);
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage());
        }
    }
	
}
