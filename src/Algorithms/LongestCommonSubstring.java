package Algorithms;

import java.util.Scanner;

public class LongestCommonSubstring {
	
	/*
	 * Finds the Longest Common Substrings using DP
	 * LCSubString[X,Y,m,n] = LCSubString[X,Y,m-1,n-1] + 1 if X[m-1] = Y[n-1]
	 * LCSubString[X,Y,m,n] = 0 otherwise
	 * Runtime : O(m*n)
	 * Space : O(m*n)
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first string");
		String firstString = sc.next();
		System.out.println("Enter the second string");
		String secondString = sc.next();
		System.out.println("The length of longest substring is " + findLongestSubString(firstString, secondString));
	}

	private static int findLongestSubString(String firstString, String secondString){
		int[][] dpArray = new int[firstString.length()+1][secondString.length()+1];
		int maxLength = 0;
		for(int i=0;i<=firstString.length();i++){
			for(int j=0;j<=secondString.length();j++){
				if(i==0 || j==0)
					dpArray[i][j] = 0;
				else if(firstString.charAt(i-1) == secondString.charAt(j-1)){
					dpArray[i][j] = dpArray[i-1][j-1] + 1;
					maxLength = Math.max(dpArray[i][j], maxLength);
				}
				else{
					dpArray[i][j] = 0;
				}
			}
		}
		return maxLength;
	}
}
