package Algorithms;

import java.util.Scanner;

public class NumberOfPathsInMatrix {

	/**
	 * Gets n which represents the size of square block
	 * Finds all possible paths from left top to right bottom of the square box
	 * Find all possible paths from the current cell through the adjacent cell in the right
	 * Find all possible paths from the current cell through the adjacent cell in the bottom
	 * Sum them to find all the possible paths through this node
	 * Recurrence : noOfPaths[i][j] = noOfPaths[i+1][j] + noOfPaths[i][j+1]
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the matrix");
		int n = sc.nextInt();
		System.out.println("Total number of paths : " + findShortPaths(1, 1, n));
	}
	
	private static int findShortPaths(int i, int j, int n){
		if(i==n && j==n)
			return 1;
		int totalDownPaths = 0;
		int totalRightPaths = 0;
		if(i<n)
			totalDownPaths = findShortPaths(i+1, j, n);
		if(j<n)
			totalRightPaths = findShortPaths(i,j+1,n);
		return totalDownPaths + totalRightPaths;
	}

}
