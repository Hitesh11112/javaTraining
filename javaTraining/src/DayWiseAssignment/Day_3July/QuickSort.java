/*
 * Quick Sort
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.*;

public class QuickSort{
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	 static int partition(int[] arr, int low, int high) {
		 int pivot = arr[high];
	        
		 int i = low - 1;

		 for (int j = low; j <= high - 1; j++) {
			 if (arr[j] < pivot) {
				 i++;
				 swap(arr, i, j);
			 }
		 }
	        
		 swap(arr, i + 1, high);  
		 return i + 1;
	 }

	    // the QuickSort function implementation
	 static void quickSort(int[] arr, int low, int high) {
		 if (low < high) {
			 int p = partition(arr, low, high);
			 quickSort(arr, low, p - 1);
			 quickSort(arr, p + 1, high);
	     }

	 }
	 
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
			
		 System.out.println("Enter the size of the array:");
		 int n = sc.nextInt();
			
		 int[] arr = new int[n];
			
		 System.out.println("Enter the elements of the array");
		 for(int idx = 0; idx < n; ++idx) {
			 arr[idx] = sc.nextInt();
		 }
			
		 quickSort(arr, 0, n - 1);
			
		 System.out.println("Sorted Array");
		 for(int ele : arr) System.out.print(ele + " ");
			
		 sc.close();
	 }
}
