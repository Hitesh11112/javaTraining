/*
 * Even numbers in Array
 * 
 */

package DayWiseAssignment.Day_3July;

import java.util.*;

public class EvenNoInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		System.out.println("Enter the elements of the array");
		for(int idx = 0; idx < n; ++idx) {
			arr[idx] = sc.nextInt();
		}
		
		System.out.println("Even no are");
		for(int idx = 0; idx < n; ++idx) {
			if(arr[idx] % 2 == 0) System.out.print(arr[idx] + " ");
		}
		sc.close();
	}
}
