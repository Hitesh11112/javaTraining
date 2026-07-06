/*
 * Selection Sort
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        
        //  sorting logic
        // 5 3 1 2 4 minPos = 1,2, min_ele = 3,1;
        // 5 3 1 2 4 
        for(int pos = 0; pos < n; ++pos) {
        		
        		int minPos= pos;
        		for(int idx = pos + 1; idx < n; ++idx) {
        			if(arr.get(idx) < arr.get(minPos)) {
        				minPos = idx;
        			}
        		}
        		int temp = arr.get(pos);
        		arr.set(pos, arr.get(minPos));
        		arr.set(minPos, temp);
        }
        
        
        System.out.println("Sorted Elements of the Array");
        for(Integer ele : arr) System.out.print(ele + " ");
        sc.close();
	}
}
