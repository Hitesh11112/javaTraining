/*
 * Bubble Sort
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        
        //  Sorting Logic
        for (int itr = 0; itr < n; ++itr) {
            for (int idx = 0; idx < n - itr - 1; ++idx) { 
                if (arr.get(idx) > arr.get(idx + 1)) {
                    int temp = arr.get(idx);
                    arr.set(idx, arr.get(idx + 1));
                    arr.set(idx + 1, temp);
                }
            }
        }
        
        System.out.println("Sorted Elements of the Array");
        for(Integer ele : arr) System.out.print(ele + " ");
        sc.close();
	}
}
