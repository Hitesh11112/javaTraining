/*
 * IllegalArgumentException
 * Thrown manually when a student's marks are entered as negative.
 */

package DayWiseAssignment.Day_7July;

public class IllegalArgumentExceptionDemo {
	
	public static void validateMarks(int marks) {
        try {
            if (marks < 0) {
                throw new IllegalArgumentException("Marks cannot be negative: " + marks);
            }
            System.out.println("Valid marks: " + marks);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }
	
}
