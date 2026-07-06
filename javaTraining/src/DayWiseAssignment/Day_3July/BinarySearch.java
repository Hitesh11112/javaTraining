/*
 * Binary Search
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.*;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the sorted elements of the array");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println("Enter the number to search");
        int target = sc.nextInt();
        
        int low = 0, high = n-1;
        
        while(low <= high) {
        		int mid =  low + (high - low) / 2;
        		
        		if(arr.get(mid) == target) {
        			System.out.println("Element found at index " + mid);
        			sc.close();
        			return;
        		}
        		if(target > arr.get(mid)) low = mid + 1;
        		else high = mid - 1;
        }
        
        System.out.println("Element not found");
        
        sc.close();
	}
}
