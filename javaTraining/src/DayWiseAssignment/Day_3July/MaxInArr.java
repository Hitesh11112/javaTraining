/*
 * Max Number in the Array
 * 
 */

package DayWiseAssignment.Day_3July;

import java.util.*;

public class MaxInArr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) arr.add(sc.nextInt());
        
        long maxNum = Long.MIN_VALUE;
        for(Integer ele : arr) maxNum = Math.max(maxNum,ele);
        
        System.out.println("The max Element of the array is " + maxNum);
        
		sc.close();
	}
}
