package Algorithms;

import java.util.Scanner;

public class LongestCommonSubSequenceDP {
	
	/*
	 * Finds the longest common sub sequence using dynamic programming
	 * Recurrence : 
	 * LCS[i][j] = LCS[i-1][j-1] + 1 if String1[i] == String2[j]
	 * else LCS[i][j] = max(LCS[i][j-1], LCS[i-1][j])
	 */

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String 1");
		String firstString = sc.next();
		System.out.println("Enter String 2");
		String secondString = sc.next();
		if(firstString != null && secondString != null)
			System.out.println("Length of Longest Common Sub sequence is : " + findLongestCommonSubSequence(firstString, secondString));
		else
			System.out.println("Length of Longest Common Sub sequence is 0");
	}
	
	private static int findLongestCommonSubSequence(String firstString, String secondString){
		int dpArray[][] = new int[firstString.length() + 1][secondString.length() + 1];		
		for(int i=0; i<=firstString.length(); i++){
			dpArray[i][0] = 0;
		}
		for(int j=0; j<=secondString.length(); j++){
			dpArray[0][j] = 0;
		}
		for(int i=1;i<=firstString.length();i++){
			for(int j=1;j<=secondString.length();j++){
				if(firstString.charAt(i-1) == secondString.charAt(j-1)){
					dpArray[i][j] = dpArray[i-1][j-1] + 1;
				}
				else{
					dpArray[i][j] = Math.max(dpArray[i-1][j], dpArray[i][j-1]);
				}
			}
		}
		return dpArray[firstString.length()][secondString.length()];
	}
}
