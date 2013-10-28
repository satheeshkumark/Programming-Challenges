package Algorithms;

import java.util.Scanner;

public class PalindromeDP {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String inputString = sc.next();
		System.out.println("Longest Palindrome sequence : " + findLPS(inputString));
	}
	
	private static String findLPS(String inputString){
		boolean palDP[][] = new boolean[inputString.length()][inputString.length()];
		for(int i=0; i<inputString.length(); i++){
			palDP[0][i] = true;
		}
		for(int i=1; i<inputString.length(); i++){
			for(int j=0; j<inputString.length() - i; j++){
				if(inputString.charAt(j) == inputString.charAt(j+i)){
					if(i-2 < 0){
						palDP[i][j] = true;
					}
					else if(i-2 >= 0 && palDP[i-2][j+1] == true){
						palDP[i][j] = true;
					}
					else{
						palDP[i][j] = false;
					}
				}
			}
		}
		printBoolArray(palDP);
		return findLongestString(inputString, palDP);
//		return;
	}
	
	private static String findLongestString(String inputString, boolean[][] dpArray){
		for(int i = inputString.length(); i>=0; i--){
			for(int j = 0; j + i < inputString.length(); j++){
				if(dpArray[i][j] == true){
					return inputString.substring(j, j+i+1);
				}
			}
		}
		return null;
	}
	
	private static void printBoolArray(boolean inputArray[][]){
		for(int i=0; i<inputArray.length; i++){
			for(int j=0; j<inputArray[0].length; j++){
				System.out.print(inputArray[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
