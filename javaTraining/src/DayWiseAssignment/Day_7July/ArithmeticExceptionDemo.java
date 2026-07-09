/*
 * ArithmeticException
 * Thrown when calculating a student's average marks with an invalid divisor.
 */

package DayWiseAssignment.Day_7July;

public class ArithmeticExceptionDemo {
	
	public static void calculateAverage(Student s) {
        try {
            int total = s.getMarks()[0] + s.getMarks()[1] + s.getMarks()[2];
            int numberOfSubjects = 0; // intentionally wrong, should be 3
            int average = total / numberOfSubjects; // throws ArithmeticException
            System.out.println("Average: " + average);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
    }
}
