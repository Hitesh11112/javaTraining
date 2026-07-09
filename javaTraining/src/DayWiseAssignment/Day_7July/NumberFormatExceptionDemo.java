/*
 * NumberFormatException
 * Thrown when trying to convert a student's mobile number (given as
 * invalid text) into a number.
 */

package DayWiseAssignment.Day_7July;

public class NumberFormatExceptionDemo {
	
	public static void convertToNumber(String input) {
        try {
            long value = Long.parseLong(input); // invalid text, not a valid number
            System.out.println("Parsed value: " + value);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }
	
}

