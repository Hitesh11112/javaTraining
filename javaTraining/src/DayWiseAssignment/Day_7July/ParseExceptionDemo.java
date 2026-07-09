/*
 * ParseException
 * Package: java.text
 *
 * Definition:
 * A checked exception thrown when a string cannot be parsed into the
 * expected format. Most commonly seen with SimpleDateFormat.parse()
 * when the input string doesn't match the date pattern defined.
 *
 * It carries an extra piece of info via getErrorOffset(), which tells
 * you the exact index in the string where parsing failed.
 */

package DayWiseAssignment.Day_7July;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class ParseExceptionDemo {
	
	// Scenario 1: Expected dd-MM-yyyy but given dd/MM/yyyy
    public static void parseWrongSeparator() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String input = "08/07/2026"; // slashes instead of dashes
            Date date = sdf.parse(input);
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            System.out.println("ParseException caught: " + e.getMessage());
            System.out.println("Error offset (index where it failed): " + e.getErrorOffset());
        }
    }

    // Scenario 2: Format expects yyyy-MM-dd but input gives dd-MM-yyyy
    public static void parseWrongOrder() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String input = "08-07-2026"; // day given first instead of year
            Date date = sdf.parse(input);
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            System.out.println("ParseException caught: " + e.getMessage());
            System.out.println("Error offset (index where it failed): " + e.getErrorOffset());
        }
    }

    // Scenario 3: Passing plain text where a date is expected
    public static void parseInvalidText() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String input = "HelloWorld";
            Date date = sdf.parse(input);
            System.out.println("Parsed date: " + date);
        } catch (ParseException e) {
            System.out.println("ParseException caught: " + e.getMessage());
            System.out.println("Error offset (index where it failed): " + e.getErrorOffset());
        }
    }

    // Scenario 4: Correct format and matching input - no exception thrown
    public static void parseValidDate() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String input = "08-07-2026"; // matches the pattern correctly
            Date date = sdf.parse(input);
            System.out.println("Parsed date successfully: " + date);
        } catch (ParseException e) {
            System.out.println("ParseException caught: " + e.getMessage());
        }
    }
	
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ParseException Demo Menu =====");
            System.out.println("1. Wrong separator in date string");
            System.out.println("2. Wrong date order (parts don't match expected pattern)");
            System.out.println("3. Completely invalid text passed as date");
            System.out.println("4. A valid date parse, for contrast");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nScenario 1: Wrong separator in date string");
                    parseWrongSeparator();
                    break;
                case 2:
                    System.out.println("\nScenario 2: Wrong date order (parts don't match expected pattern)");
                    parseWrongOrder();
                    break;
                case 3:
                    System.out.println("\nScenario 3: Completely invalid text passed as date");
                    parseInvalidText();
                    break;
                case 4:
                    System.out.println("\nScenario 4: A valid date parse, for contrast (completes normally)");
                    parseValidDate();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
	
}
