package Algorithms;

import java.util.Scanner;

public class NumberOfPathsInMatrixDP {

	/**
	 * Gets n which represents the size of square block
	 * Bottom up approach for finding all possible paths from left top to right bottom of the square box
	 * Recurrence : noOfPaths[i][j] = noOfPaths[i-1][j] + noOfPaths[i][j-1] 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = sc.nextInt();
		System.out.println(findUniquePathsCount(n));
	}

	private static int findUniquePathsCount(int n){
		int[][] dpArray = new int[n][n];
		for(int i=0; i<n; i++)
			dpArray[i][0] = 1;
		for(int j=0; j<n; j++)
			dpArray[0][j] = 1;
		for(int i=1;i<n;i++){
			for(int j=1;j<n;j++){
				dpArray[i][j] = dpArray[i-1][j] + dpArray[i][j-1]; 
			}
		}
		return dpArray[n-1][n-1];
	}
}

