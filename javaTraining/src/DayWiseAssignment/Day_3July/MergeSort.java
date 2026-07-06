/*
 * Merge Sort
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.*;

public class MergeSort {
	
	// merging both array
	static void merge(int arr[], int low, int mid, int high) { 
		int a1Size = mid - low + 1;
		int a2Size = high - mid;
		
		// make 2 array;
		int[] a1 = new int[a1Size];
		int[] a2 = new int[a2Size];
		
		//6 5 4 3 2 1
		for(int idx = 0; idx < a1Size; ++idx) a1[idx] = arr[low+idx];
		for(int idx = 0; idx < a2Size; ++idx) a2[idx] = arr[mid+1+idx];
		
		// Now merge 2 array { same question }
		int i = 0, j = 0;
		
		//changing directly to the main array so we need the starting index which is low;
		int k = low;
		while(i < a1Size && j < a2Size) {
			if(a1[i] < a2[j]) arr[k] = a1[i++];
			else arr[k] = a2[j++];
			k +=1;
		}
		
		//Remaining elements from a1
		while(i < a1Size) arr[k++] = a1[i++];
		//Remaining elements from a2
		while(j < a2Size) arr[k++] = a2[j++];
	}
	
	static void mergeSort(int arr[], int low, int high) { 
		if(low < high) {
			int mid = low + (high - low) / 2;
			
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			
			merge(arr,low,mid,high);
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
		
		mergeSort(arr,0,n-1);
		
		System.out.println("Sorted Array");
		for(int ele : arr) System.out.print(ele + " ");
		
		sc.close();
	}
}
