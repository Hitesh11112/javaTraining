/*
 * Delete at given Index
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.*;

public class DeletionAtGivenPosition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        
        System.out.println("Enter the index for deletion: ");
        int pos = sc.nextInt();
        
        // verify
        if(pos < 0 || pos >= n) {
	    		System.out.println("Position is out of bounds");
	    		sc.close();
	    		return;
	    }
        
        //deletion logic
        for(int idx = pos; idx < n-1; ++idx) arr.set(idx, arr.get(idx+1));
        arr.remove(n-1);
        
        System.out.println("Updated Array");
        for(Integer i : arr) System.out.print(i + " ");
        
		sc.close();
	}
}
