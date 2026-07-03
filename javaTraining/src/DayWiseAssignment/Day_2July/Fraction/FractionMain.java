package DayWiseAssignment.Day_2July.Fraction;

import java.util.Scanner;

public class FractionMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input first fraction
        System.out.print("Enter numerator of first fraction: ");
        int num1 = sc.nextInt();

        System.out.print("Enter denominator of first fraction: ");
        int den1 = sc.nextInt();

        // Input second fraction
        System.out.print("Enter numerator of second fraction: ");
        int num2 = sc.nextInt();

        System.out.print("Enter denominator of second fraction: ");
        int den2 = sc.nextInt();

        // Add fractions
        int numerator = (num1 * den2) + (num2 * den1);
        int denominator = den1 * den2;

        System.out.println("Sum = " + numerator + "/" + denominator);

        sc.close();
    }

    
}
