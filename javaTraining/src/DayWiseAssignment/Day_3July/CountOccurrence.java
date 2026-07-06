/*
 * Count Occurrence
 * 
 */

package DayWiseAssignment.Day_3July;

import java.util.*;

public class CountOccurrence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        
        System.out.println("Enter the element whose freq to find");
        int num = sc.nextInt();
        
        int cnt = 0;
        for (int element : arr) {
            if (element == num) cnt++;
        }
        
        System.out.println("The freq of the "+  num + " is " + cnt );
		
		sc.close();
	}
}
