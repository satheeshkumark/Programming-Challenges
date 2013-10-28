package Algorithms;

import java.util.Scanner;

public class MatrixMultipliclation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of matrices");
		int n = sc.nextInt();
		int matrixDimensions[] = new int[n + 1];
		System.out.println("Enter " + (n+1) + " values");
		for(int i=0;i<=n;i++){
			matrixDimensions[i] = sc.nextInt();
		}
		System.out.println("The minimum number of Operations required : " + findMinOperations(matrixDimensions, 1, n));
	}
	
	private static int findMinOperations(int[] matrixDimensions, int i, int j){
		if(i==j)
			return 0;
		int minCost = 30000;
		for(int k=i;k<j;k++){
			int totalCost = findMinOperations(matrixDimensions, i, k) + findMinOperations(matrixDimensions, k+1, j) + matrixDimensions[i-1] * matrixDimensions[k] * matrixDimensions[j];
			if(minCost > totalCost){
				minCost = totalCost;
			}
		}
		return minCost;
	}

}
