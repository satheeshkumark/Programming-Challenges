package Algorithms;

import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = sc.nextInt();
		System.out.println("Enter " + n +" values one by one");
		int inputArray[] = new int[n];
		for(int i=0; i<n;i++)
			inputArray[i] = sc.nextInt();
		findLIS(inputArray);
	}

	private static void findLIS(int[] inputArray){
		int[] sequenceLength = new int[inputArray.length];
		int[] maxPointer = new int[inputArray.length];
		sequenceLength[0] = 1;
		for(int i = 1; i < inputArray.length; i++){
			for(int j = 0; j < i; j++){
				if(inputArray[i] > inputArray[j]){
					if(sequenceLength[i] < sequenceLength[j] + 1){
						sequenceLength[i] = sequenceLength[j] + 1;
						maxPointer[i] = j;
					}
				}
				else{
					if(sequenceLength[i] < sequenceLength[j]){
						sequenceLength[i] = sequenceLength[j];
						maxPointer[i] = j;
					}
				}
			}
		}
		System.out.println("Maximum Sequence Length : " + sequenceLength[inputArray.length - 1]);
		printPath(inputArray, maxPointer, sequenceLength);
	}
	
	
	private static void printPath(int[] inputArray, int[] maxPointer, int[] sequenceLength){
		int maxIndex = sequenceLength.length - 1;
		while(sequenceLength[maxIndex] == sequenceLength[maxPointer[maxIndex]])
			maxIndex = maxPointer[maxIndex];
		while(true){
			System.out.print(inputArray[maxIndex] + "\t");
			int newmaxIndex = maxPointer[maxIndex];
			if(sequenceLength[maxIndex] == sequenceLength[newmaxIndex])
				break;
			maxIndex = newmaxIndex;
		}
		return;
	}
}
