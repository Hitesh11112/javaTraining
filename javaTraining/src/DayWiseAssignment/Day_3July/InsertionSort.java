/*
 * Insertion Sort
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        // sorting Logic
        // 1 2 4 5 3
        for(int curr = 1; curr < n; ++curr) {
        		int ele = arr.get(curr);
        		int prev= curr - 1;
        		while(prev >= 0 && arr.get(prev) > ele) {
        			arr.set(prev+1, arr.get(prev));
        			prev -=1;
        		}
        		arr.set(prev+1, ele);
        }
        
        System.out.println("Sorted Elements of the Array");
        for(Integer ele : arr) System.out.print(ele + " ");
        sc.close();
	}
}
