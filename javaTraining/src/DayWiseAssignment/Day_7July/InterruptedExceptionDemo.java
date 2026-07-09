/*
 * ===================================================================
 * InterruptedException
 * Package: java.lang (auto-imported, no explicit import needed)
 *
 * Definition:
 * A checked exception thrown when a thread that is sleeping, waiting,
 * or blocked (via Thread.sleep(), Object.wait(), Thread.join()) is
 * interrupted by another thread (or itself) calling interrupt() on it.
 *
 * Note: No separate Thread object is created here. Every Java program
 * runs on a thread automatically (the "main" thread), so we simply
 * interrupt that main thread ourselves before making it sleep.
 * ===================================================================
 */

package DayWiseAssignment.Day_7July;

import java.util.Scanner;

public class InterruptedExceptionDemo {

	
	// Interrupt main thread first, then try to sleep - throws InterruptedException immediately
    public static void interruptThenSleep() {
        try {
            Thread.currentThread().interrupt(); // mark main thread as interrupted
            System.out.println("Attempting to sleep for 1000 ms...");
            Thread.sleep(1000); // throws because interrupt flag is already set
            System.out.println("This line will never execute.");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught: " + e.getMessage());
        }
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== InterruptedException Demo Menu =====");
            System.out.println("1. Interrupt main thread, then sleep");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nScenario: Interrupt main thread, then sleep");
                    interruptThenSleep();
                    break;
                case 2:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 2);

        sc.close();
    }
	
}
