/*
 * Prime Number
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.*;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
		int n = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		System.out.println("Enter the elements of the array");
		for(int idx = 0; idx < n; ++idx) {
			arr.add(sc.nextInt());
		}
		
		System.out.println("The prime Number in the array are: ");
		for(int curr = 0; curr < n; ++curr) {
			boolean get = true;
			if(arr.get(curr) < 2) get = false;
			for(int idx = 2; idx * idx  <= arr.get(curr); ++idx) {
				if(arr.get(curr) % idx == 0) {
					get = false;
					break;
				}
			}
			if(get) System.out.println(arr.get(curr) + " ");
		}
		
		sc.close();
	}
}
