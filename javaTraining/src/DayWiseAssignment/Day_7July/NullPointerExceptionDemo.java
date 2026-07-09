/*
 * NullPointerException
 * Thrown when generating reports for multiple students, and one
 * student record in the array is null.
 */

package DayWiseAssignment.Day_7July;	

public class NullPointerExceptionDemo {
	
	public static void generateReports(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            try {
                System.out.println("Report for: " + students[i].getName()); // throws NPE if student is null
            } catch (NullPointerException e) {
                System.out.println("NullPointerException caught: Student record missing at index " + i);
            }
        }
    }
	
}
