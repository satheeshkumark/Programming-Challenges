package Algorithms;
import java.util.Scanner;

/*
 * Satheeshkumar Karuppusamy, satheeshusc@gmail.com
 * 
 *	Problem :
 *		Search the given pattern in the input string 
 *
 *  Algorithm :
 *  	KMP DP algorithm
 *  	Form the kmp table which reduces the backtracking length for searching a particular pattern
 *  	Use the kmp table to search the occurrence of the pattern in the main string 
 *  Run Time : 
 *  	Table Preparation : theta(n)
 *  	Search : theta(m)
 *  	n - length of the pattern
 *  	m - length of the inputString
*/


public class StringSearchKMP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input String");
		String inputString = sc.next();
		System.out.println("Enter the search Pattern");
		String searchPattern = sc.next();
		int startPosition = searchPattern(inputString, searchPattern);
		System.out.println("The input Pattern is found at " + startPosition);
	}
	
	static int searchPattern(String inputString, String searchPattern){
		int[] kmpTable = prepareKMPTable(searchPattern);
		int strlen = inputString.length();
		int m = 0;
		int i = 0;
		int startIndex = -1;
		while(m + i < strlen){
			if(inputString.charAt(m + i) == searchPattern.charAt(i)){
				i++;
				if(i == searchPattern.length()){
					startIndex = m;
					System.out.println("Returning");
					return m;
				}
			}
			else{
				if(kmpTable[i] != -1){
					m = m + i - kmpTable[i];
					i = kmpTable[i];
				}
				else{
					m++;
					i = 0;
				}
			}
		}
		return startIndex;
	}
	
	static int[] prepareKMPTable(String searchPattern){
		int[] kmpTable = new int[searchPattern.length()];
		int j = 0;
		kmpTable[0] = -1;
		for(int i = 1; i<kmpTable.length; i++){
			if(searchPattern.charAt(i) == searchPattern.charAt(j)){
				kmpTable[i] = j;
				j++;
			}
			else{
				kmpTable[i] = -1;
				j = 0;
			}
		}
		return kmpTable;
	}

}
