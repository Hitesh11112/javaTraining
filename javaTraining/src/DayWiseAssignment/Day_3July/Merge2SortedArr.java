/*
 * Merge 2 Sorted Array 
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.*;

public class Merge2SortedArr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//for 1st array
		System.out.println("Enter the size of the 1st array");
		int n = sc.nextInt();
		
		ArrayList<Integer> arr1 = new ArrayList<>();
		
		System.out.println("Enter the elements of the 1st array");
		for(int idx = 0; idx < n; ++idx) {
			arr1.add(sc.nextInt());
		}
		
		//for 2nd array
		System.out.println("Enter the size of the 2nd array");
		int m = sc.nextInt();
		
		ArrayList<Integer> arr2 = new ArrayList<>();
		
		System.out.println("Enter the elements of the 2nd array");
		for(int idx = 0; idx < m; ++idx) {
			arr2.add(sc.nextInt());
		}
		
		//Logic
		ArrayList<Integer> result = new ArrayList<>();
		
		//i for arr1 and j for arr2
		int i = 0, j = 0;
		while(i < n && j < m) {
			int num1 = arr1.get(i);
			int num2 = arr2.get(j);
			
			if(num1 > num2) {
				result.add(num2);
				j +=1;
			}else {
				result.add(num1);
				i +=1;
			}
		}
		
		while(i < n) result.add(arr1.get(i++));
		while(j < m) result.add(arr2.get(j++));
		
		System.out.println("Sorted Merge Array is ");
		for(Integer ele : result) System.out.print(ele + " ");
		
		sc.close();
	}
}
