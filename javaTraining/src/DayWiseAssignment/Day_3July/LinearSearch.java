/*
 * Linear Search
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.*;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println("Enter the number to search");
        int target = sc.nextInt();

        for (int idx = 0; idx < arr.size(); idx++) {
            if (arr.get(idx) == target) {
                System.out.println("Element found at index " + idx);
                sc.close();
                return;
            }
        }

        System.out.println("Element not found in the array");

        sc.close();
    }
}