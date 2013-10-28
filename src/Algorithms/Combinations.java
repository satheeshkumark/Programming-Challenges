package Algorithms;

import java.util.Scanner;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = sc.nextInt();
		System.out.println("Enter the vaue of k");
		int k = sc.nextInt();
		System.out.println("The result is " + findCombination(n, k));
	}
	
	private static int findCombination(int n, int k){
		int combinations[][] = new int[n + 1][n + 1];
		combinations[0][0] = 1;
		for(int i = 1; i <= n; i++){
			for(int j=0; j <= i; j++){
				if(j == 0 || j == i){
					combinations[i][j] = 1;
					continue;
				}
				combinations[i][j] = combinations[i - 1][j - 1] + combinations[i - 1][j];
			}
		}
		printCombination(combinations);
		return combinations[n][k];
	}
	
	private static void printCombination(int[][] inputArray){
		for(int i=0; i<inputArray.length; i++){
			for(int j=0; j<inputArray[0].length; j++){
				System.out.print(inputArray[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
