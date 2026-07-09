/*
 * IOException
 * Package: java.io
 * A checked exception thrown when an input/output operation fails -
 * e.g. trying to read a file that doesn't exist, a stream being closed
 * unexpectedly, or a disk/network error.
 */

package DayWiseAssignment.Day_7July;

import java.io.*;
import java.util.Scanner;

public class IOExceptionDemo {
	
	// Scenario 1: FileNotFoundException is a subclass of IOException
    public static void readNonExistentFile() {
        BufferedReader reader = null;
        try {
            FileReader file = new FileReader("nonExistentFile.txt");
            reader = new BufferedReader(file);
            String line = reader.readLine();
            System.out.println("Read line: " + line);
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block: cleanup step (closing reader if it was opened).");
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing reader: " + e.getMessage());
            }
        }
    }

    // Scenario 2: A working example first, to show contrast
    public static void writeAndReadFile() {
        String fileName = "tempTestFile.txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Hello, this is a test line.");
            writer.close();
            System.out.println("File written successfully: " + fileName);

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String content = reader.readLine();
            System.out.println("File content read back: " + content);
            reader.close();

        } catch (IOException e) {
            System.out.println("IOException caught during write/read: " + e.getMessage());
        }
    }

    // Scenario 3: Forcing IOException by writing to an already-closed stream
    public static void useClosedStream() {
        try {
            FileWriter writer = new FileWriter("tempTestFile.txt");
            writer.write("Some data");
            writer.close(); // stream closed here

            writer.write("Trying to write after close"); // this line throws IOException
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== IOException Demo Menu =====");
            System.out.println("1. Reading a non-existent file");
            System.out.println("2. Writing to a file and reading it back successfully");
            System.out.println("3. Writing to a stream after it's already closed");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nScenario 1: Reading a non-existent file");
                    readNonExistentFile();
                    break;
                case 2:
                    System.out.println("\nScenario 2: Writing to a file and reading it back successfully");
                    writeAndReadFile();
                    break;
                case 3:
                    System.out.println("\nScenario 3: Writing to a stream after it's already closed");
                    useClosedStream();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
	}
}
