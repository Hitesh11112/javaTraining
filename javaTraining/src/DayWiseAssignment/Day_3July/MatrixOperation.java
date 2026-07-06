/*
 * Matrix Operation Addition, Subtraction & Multiplication
 * 
*/

package DayWiseAssignment.Day_3July;

import java.util.*;

public class MatrixOperation {
	
	static void printMatrix(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//By Switch Case
		System.out.println("1. Addition"); 
		System.out.println("2. Subtraction"); 
		System.out.println("3. Multiplication"); 
		System.out.print("Enter your choice: ");
		
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1:
				
				System.out.println("Enter rows and cols:");
                int row = sc.nextInt();
                int col = sc.nextInt();

                int[][] arr1 = new int[row][col];
                int[][] arr2 = new int[row][col];

                System.out.println("Enter elements of Matrix 1:");
                for(int i = 0; i < row; i++) {
                    for(int j = 0; j < col; j++) {
                        arr1[i][j] = sc.nextInt();
                    }
                }

                System.out.println("Enter elements of Matrix 2:");
                for(int i = 0; i < row; i++) {
                    for(int j = 0; j < col; j++) {
                        arr2[i][j] = sc.nextInt();
                    }
                }

                int[][] result = new int[row][col];

                for(int i = 0; i < row; i++) {
                    for(int j = 0; j < col; j++) {
                    		result[i][j] = arr1[i][j] + arr2[i][j];
                    }
                }

                System.out.println("Result:");
                printMatrix(result);
                break;

				
			case 2:
				
				System.out.println("Enter rows and cols:");
                int row2 = sc.nextInt();
                int col2 = sc.nextInt();

                int[][] arr3 = new int[row2][col2];
                int[][] arr4 = new int[row2][col2];

                System.out.println("Enter elements of Matrix 1:");
                for(int i = 0; i < row2; i++) {
                    for(int j = 0; j < col2; j++) {
                        arr3[i][j] = sc.nextInt();
                    }
                }

                System.out.println("Enter elements of Matrix 2:");
                for(int i = 0; i < row2; i++) {
                    for(int j = 0; j < col2; j++) {
                        arr4[i][j] = sc.nextInt();
                    }
                }

                int[][] res = new int[row2][col2];

                for(int i = 0; i < row2; i++) {
                    for(int j = 0; j < col2; j++) {
                    		res[i][j] = arr3[i][j] - arr4[i][j];
                    }
                }

                System.out.println("Result:");
                printMatrix(res);
                break;

				
			case 3:
				/*
				 * | a b c |   | j k l |   | aj+bm+cp   ak+bn+cq   al+bo+cr |
				 * | d e f | x | m n o | = | dj+em+fp   dk+en+fq   dl+eo+fr |
				 * | g h i |   | p q r |   | gj+hm+ip   gk+hn+iq   gl+ho+ir |
				 * 
				 */
				System.out.println("Enter rows and cols of Matrix 1:");
                int r1 = sc.nextInt();
                int c1 = sc.nextInt();

                System.out.println("Enter rows and cols of Matrix 2:");
                int r2 = sc.nextInt();
                int c2 = sc.nextInt();

                if(c1 != r2) {
                    System.out.println("Matrix multiplication not possible");
                    sc.close();
                    return;
                }

                int[][] mat1 = new int[r1][c1];
                int[][] mat2 = new int[r2][c2];

                System.out.println("Enter elements of Matrix 1:");
                for(int i = 0; i < r1; i++) {
                    for(int j = 0; j < c1; j++) {
                        mat1[i][j] = sc.nextInt();
                    }
                }

                System.out.println("Enter elements of Matrix 2:");
                for(int i = 0; i < r2; i++) {
                    for(int j = 0; j < c2; j++) {
                        mat2[i][j] = sc.nextInt();
                    }
                }

                int[][] mul = new int[r1][c2];

                for(int i = 0; i < r1; i++) {
                    for(int j = 0; j < c2; j++) {
                        for(int k = 0; k < c1; k++) {
                            mul[i][j] += mat1[i][k] * mat2[k][j];
                        }
                    }
                }

                System.out.println("Result:");
                printMatrix(mul);
                break;	
                
			default:
				System.out.println("Wrong input");
				break;
		}
		
		
		sc.close();
	}
}
