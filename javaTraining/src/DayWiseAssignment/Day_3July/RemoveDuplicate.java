/*
 * Remove Duplicates
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.*;


public class RemoveDuplicate {
	
	 static void RemoveAllDuplicate(ArrayList<Integer> arr) {
		 HashSet<Integer> st = new HashSet<>(arr);

		 System.out.println("Array after removing duplicates:");
	     System.out.println(st);
	 }
	
	// Remove a given element from the array
	 static void RemoveGivenDuplicate(ArrayList<Integer> arr, int target) {

		 ArrayList<Integer> ans = new ArrayList<>();

		 for(int num : arr) {
			 if(num != target) {
				 ans.add(num);
			 }
		 }

		 System.out.println("Array after removing " + target + ":");
		 System.out.println(ans);
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
		
		System.out.println("Original Array:");
	    System.out.println(arr);
	    
	    // Remove a specific element
        System.out.println("Enter the element to remove:");
        int target = sc.nextInt();
        
	    // Remove all duplicates
        RemoveAllDuplicate(arr);

        //Remove on given element
        RemoveGivenDuplicate(arr, target);
		
		sc.close();
	}
}
