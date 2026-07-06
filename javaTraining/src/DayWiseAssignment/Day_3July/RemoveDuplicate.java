/*
 * Remove Duplicates
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.*;


public class RemoveDuplicate {
	
	static void RemoveAllDuplicate() {
		
	}
	
	static void RemoveGivenDuplicate() {
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array:");
		int n = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		System.out.println("Enter the elements of the array");
		for(int idx = 0; idx < n; ++idx) {
			arr.add(sc.nextInt());
		}
		
		
		
		sc.close();
	}
}
