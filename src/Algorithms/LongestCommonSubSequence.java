package Algorithms;

import java.util.Scanner;

public class LongestCommonSubSequence {

	/**
	 * Gets two Strings as input from command prompt
	 * Finds the longest common sub sequence using the recurrence as given below
	 * LCS[i,j] = 1 + LCS[i+1,j+1] if String1[i] = String2[j]
	 * LCS[i,j] = max(LCS[i+1,j], LCS[i,j+1]) if String1[i] != String2[j]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first String");
		String firstString = sc.next();
		System.out.println("Enter the second String");
		String secondString = sc.next();
		System.out.println("Length of Longest Common Subsequence : " + findLongestSubsequence(firstString, secondString, 0, 0));
	}
	
	private static int findLongestSubsequence(String firstString, String secondString, int i, int j){
		if(firstString == null || secondString == null)
			return 0;
		if(i == firstString.length() || j == secondString.length())
			return 0;
		if(firstString.charAt(i) == secondString.charAt(j)){
			return 1 + findLongestSubsequence(firstString, secondString, i+1,j+1);
		}
		else{
			return Math.max(findLongestSubsequence(firstString, secondString, i+1, j), findLongestSubsequence(firstString, secondString, i, j+1));
		}
	}
}
