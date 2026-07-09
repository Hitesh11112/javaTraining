/*
 * Main class - creates student entries and drives the menu.
 * Calls into separate exception-demo classes for each scenario.
 */

package DayWiseAssignment.Day_7July;

import java.util.Scanner;

public class StudentMain {
	 
	public static void displayAllStudents(Student[] students) {
        System.out.println("===== All Student Records =====");
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            if (s == null) {
                System.out.println("Student at index " + i + ": Record missing (null)");
                continue;
            }
            System.out.println("\nStudent Index: " + i);
            System.out.println("Name    : " + s.getName());
            System.out.println("ID      : " + s.getId());
            System.out.print("Marks   : ");
            for (int m : s.getMarks()) {
                System.out.print(m + " ");
            }
            System.out.println();
            System.out.println("Mobile  : " + s.getMobileNo());
            System.out.println("Email   : " + s.getEmail());
            System.out.println("Branch  : " + s.getBranch());
        }
    }
	
	 public static void main(String[] args) {
	        // Creating student entries here
		 	Student[] students = new Student[5];
	        students[0] = new Student("Hitesh", 101, new int[]{80, 90, 85}, "9876543210", "hitesh@mail.com", "CSE");
	        students[1] = null; // missing record, will trigger NullPointerException
	        students[2] = new Student("Aman", 102, new int[]{70, 60}, "9123456789", "aman@mail.com", "IT"); // incomplete marks
	        students[3] = new Student("Priya", 103, new int[]{95, 88, 92}, "9988776655", "priya@mail.com", "ECE");
	        students[4] = new Student("Rahul", 104, new int[]{60, 75, 80}, "9001122334", "rahul@mail.com", "MECH");

	        // Print all student details first
	        displayAllStudents(students);
	        Scanner sc = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n===== Student Marks Report - Exception Menu =====");
	            System.out.println("1. ArithmeticException (calculate average)");
	            System.out.println("2. NullPointerException (multiple student reports)");
	            System.out.println("3. ArrayIndexOutOfBoundsException (multiple student reports)");
	            System.out.println("4. StringIndexOutOfBoundsException");
	            System.out.println("5. IllegalArgumentException");
	            System.out.println("6. NumberFormatException");
	            System.out.println("7. ClassCastException");
	            System.out.println("8. ClassNotFoundException");
	            System.out.println("9. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    ArithmeticExceptionDemo.calculateAverage(students[0]);
	                    break;
	                case 2:
	                    NullPointerExceptionDemo.generateReports(students);
	                    break;
	                case 3:
	                    ArrayIndexOutOfBoundsExceptionDemo.generateReports(students);
	                    break;
	                case 4:
	                    StringIndexOutOfBoundsExceptionDemo.accessInvalidIndex(students[2]); // branch = "IT"
	                    break;
	                case 5:
	                    IllegalArgumentExceptionDemo.validateMarks(-5);
	                    break;
	                case 6:
	                    NumberFormatExceptionDemo.convertToNumber(students[0].getMobileNo() + "ABC"); // corrupt input
	                    break;
	                case 7:
	                    ClassCastExceptionDemo.castObject(students[0]);
	                    break;
	                case 8:
	                    ClassNotFoundExceptionDemo.loadClass();
	                    break;
	                case 9:
	                    System.out.println("Exiting program.");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }
	        } while (choice != 9);

	        sc.close();
	    }
}
