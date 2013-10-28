package Algorithms;

import java.util.Scanner;

public class MatrixChainMultiplicationDP {

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
		System.out.println("The minimum number of Operations required : " + findMinOperations(matrixDimensions));
	}
	
	private static int findMinOperations(int[] matrixDimensions){
		int[][] dpTable = new int[matrixDimensions.length][matrixDimensions.length];
		for(int i=0;i<matrixDimensions.length;i++)
				dpTable[i][i] = 0;
		for(int i=1;i<matrixDimensions.length-1;i++)
			dpTable[i][i+1] = matrixDimensions[i];
		for(int length = 2; length<matrixDimensions.length - 1;length++){
			System.out.println("length value : " + length);
			for(int i = 1; i<=matrixDimensions.length - length; i++){
				int j = i + length - 1;
				dpTable[i][j] = 32767;
				System.out.println(i + "  " + j);
				for(int k=i; k<=j - 1; k++){
					int currentCost = dpTable[i][k] * dpTable[k+1][j] + matrixDimensions[i-1] * matrixDimensions[i] * matrixDimensions[k];
					if(dpTable[i][j] > currentCost)
						dpTable[i][j] = currentCost;
					System.out.println(i + "  " + "  " + j + "   " + k + "   " + currentCost);
				}
			}
		}
		printCostMatrix(dpTable);
		return dpTable[matrixDimensions.length - 2][matrixDimensions.length - 1];
	}

	private static void printCostMatrix(int[][] costMatrix){
		for(int i=0;i<costMatrix.length;i++){
			for(int j=0;j<costMatrix[0].length;j++){
				System.out.print(costMatrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
