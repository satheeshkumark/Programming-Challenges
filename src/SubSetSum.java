import java.util.Arrays;
import java.util.Scanner;

/*
 * Subset sum problem
 * 
 * Finds whether any subset from the given set of positive and negative numbers can form the expected sum
 * Input can be any integer array with positive or negative integers and the sum to be found in that array by considering the subset of elements which can be a positive or a negative number
 * 
 * Runtime : O(Nn) - Pseudo polynomial time
 * N - total negative sum to total positive sum if there is a negative number or from zero to positive sum
 * n - number of elements
 * 
 * Space complexity : O(Nn) - DPTable
 */

public class SubSetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n = sc.nextInt();
		if(n<=0){
			System.out.println("Enter numbers greater than 0");
			return;
		}
		int inputArray[] = new int[n];
		System.out.println("Enter " + n + " values one in a line");
		for(int i=0;i<n;i++){
			inputArray[i] = sc.nextInt();
		}
		System.out.println("Enter the target sum");
		int targetSum = sc.nextInt();
		if(subSetSum(inputArray, targetSum))
			System.out.println("Sub array of required sum exists");
		else
			System.out.println("Sub array of required sum doesnt exist");
	}
	
	private static boolean subSetSum(int inputArray[], int targetSum){
		int positiveSum = 0;
		Arrays.sort(inputArray);
		for(int currentElement : inputArray){
			positiveSum += currentElement;
		}
		if(targetSum > positiveSum)
			return false;
		boolean dpTable[][] = new boolean[positiveSum + 1][inputArray.length];
		int currentXIndex = 0;
		int currentSum = 0;
		for(; currentSum<=positiveSum; currentSum ++){
			int currentYIndex = 0;
			for(int currentElement : inputArray){
				if(currentElement == currentSum){
					dpTable[currentXIndex][currentYIndex] = true;
				}
				else if(currentYIndex - 1 >= 0){
					int remainingSumIndex = currentSum - currentElement;
					if(dpTable[currentXIndex][currentYIndex - 1] == true){
						dpTable[currentXIndex][currentYIndex] = true;
					}
					else if(remainingSumIndex >= 0 && dpTable[remainingSumIndex][inputArray.length - 1] == true){
						dpTable[currentXIndex][currentYIndex] = true;
					}
					else
						dpTable[currentXIndex][currentYIndex] = false;
				}
				else{
					dpTable[currentXIndex][currentYIndex] = false;
				}
				currentYIndex += 1;
			}
			currentXIndex += 1;
		}
		//printDPTable(dpTable);
		return dpTable[targetSum][inputArray.length - 1];
	}
	
	private static void printDPTable(boolean[][] inputArray){
		for(int i=0; i<inputArray.length; i++){
			for(int j=0; j<inputArray[0].length; j++){
				System.out.print(inputArray[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
