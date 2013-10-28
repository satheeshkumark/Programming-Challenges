package Algorithms;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String1 : ");
		String firstString = sc.next();
		System.out.println("Enter String2 : ");
		String secondString = sc.next();
		System.out.println("Edit distance between two strings is : " + findEditDistance(firstString, secondString));
	}
	
	private static int findEditDistance(String firstString, String secondString){
		int deletionCost = 1;
		int substitutionCost = 1;
		int insertionCost = 1;
		int dpTable[][] = new int[firstString.length() + 1][secondString.length() + 1];
		for(int i = 0; i <=firstString.length(); i++)
			dpTable[i][0] = i;
		for(int j = 0; j <=secondString.length(); j++)
			dpTable[0][j] = j;
		for(int i = 1; i <= firstString.length(); i++){
			for(int j = 1; j <= secondString.length(); j++){
				if(firstString.charAt(i - 1) == secondString.charAt(j - 1)){
					dpTable[i][j] = dpTable[i-1][j-1];
				}
				else{
					dpTable[i][j] = findMinimum(deletionCost + dpTable[i-1][j], substitutionCost + dpTable[i-1][j-1], insertionCost + dpTable[i][j-1]);
				}
			}
		}
//		print2DArray(dpTable);
		return dpTable[firstString.length()][secondString.length()];
	}
	
	private static int findMinimum(int a, int b, int c){
		int min = a;
		min = b<min?b:min;
		min = c<min?c:min;
		return min;
	}

	private static void print2DArray(int[][] inputArray){
		for(int i=0; i<inputArray.length; i++){
			for(int j=0; j<inputArray[0].length; j++){
				System.out.print(inputArray[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
