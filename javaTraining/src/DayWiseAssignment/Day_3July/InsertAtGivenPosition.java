/*
 * Insert at given Index
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.*;

public class InsertAtGivenPosition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        
        System.out.println("Enter the index for insertion: ");
        int pos = sc.nextInt();
        
        System.out.println("Enter the element to be inserted");
        int ele = sc.nextInt();
        
        //verify
        if(pos < 0 || pos > n) {
	    		System.out.println("Position is out of bounds");
	    		sc.close();
	    		return;
	    }
        
        //add another element in the array
        arr.add(-1);
        
        for(int idx = n-1; idx >= pos; --idx) {
        		arr.set(idx+1, arr.get(idx));
        }
        arr.set(pos, ele);

        System.out.println("Updated Array");
        for(Integer i : arr) System.out.print(i + " ");
        
		sc.close();
	}
}
