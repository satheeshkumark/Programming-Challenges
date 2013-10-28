package Algorithms;

import java.util.Scanner;

public class CoinChangeProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of denominations ");
		int n = sc.nextInt();
		int denominations[] = new int[n];
		System.out.println("Enter the different denomination values one by one");
		for(int i=0;i<n;i++)
			denominations[i] = sc.nextInt();
		System.out.println("Enter the sum that needs to be formed");
		int targetSum = sc.nextInt();
		System.out.println("The minimum number of coins need to form target sum is : " + findMinCoins(denominations, targetSum));
	}
	
	private static int findMinCoins(int[] denominations, int targetSum){
		int dpTable[] = new int[targetSum + 1];
		dpTable[0] = 0;
		for(int i=1;i<=targetSum;i++){
			dpTable[i] = i;
			for(int j=0;j<denominations.length;j++){
				if(i - denominations[j] >= 0 && dpTable[i] > 1 + dpTable[i - denominations[j]])
					dpTable[i] = 1 + dpTable[i - denominations[j]];
			}
		}
		return dpTable[targetSum];
	}

}
