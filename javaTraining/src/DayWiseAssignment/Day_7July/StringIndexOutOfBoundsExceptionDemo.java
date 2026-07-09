/*
 * StringIndexOutOfBoundsException
 * Thrown when accessing a character index that doesn't exist in a
 * student's branch name.
 */

package DayWiseAssignment.Day_7July;

public class StringIndexOutOfBoundsExceptionDemo {
		
	public static void accessInvalidIndex(Student s) {
        try {
            char ch = s.getBranch().charAt(5); // index 5 likely doesn't exist
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }
	
}
