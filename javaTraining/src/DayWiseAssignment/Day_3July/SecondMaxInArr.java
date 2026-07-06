/*
 * 2nd Max Number in the Array
 * 
 */

package DayWiseAssignment.Day_3July;

import java.util.*;

class Pair{
	int first;
	int second;
	
	public Pair() {}
	public Pair(int fst, int sec) {
		this.first = fst;
		this.second = sec;
	}
};

public class SecondMaxInArr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) arr.add(sc.nextInt());
        
        Pair p = new Pair(Integer.MIN_VALUE,Integer.MIN_VALUE);
        
        for(Integer ele : arr) {
        		if(ele > p.first) { p.second = p.first; p.first = ele; } 
        		else if (ele > p.second) p.second = ele; //if duplicate allowed 
        		
        }
        
        System.out.println("The second greatest element in the array is "+ p.second);
		sc.close();
	}
}
