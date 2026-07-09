/*
 * ArrayIndexOutOfBoundsException
 * Thrown when a student's marks array doesn't have all 3 subject marks.
 */

package DayWiseAssignment.Day_7July;

public class ArrayIndexOutOfBoundsExceptionDemo {
	
	public static void generateReports(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            try {
                Student s = students[i];
                int total = s.getMarks()[0] + s.getMarks()[1] + s.getMarks()[2]; // throws if marks.length < 3
                System.out.println("Total for " + s.getName() + ": " + total);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException caught: Marks incomplete for student index " + i);
            }
        }
    }
	
}
