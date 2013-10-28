package Algorithms;

import java.util.Scanner;

public class JumpProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = sc.nextInt();
		System.out.println("Enter " + n +" values one by one");
		int inputArray[] = new int[n];
		for(int i=0; i<n;i++)
			inputArray[i] = sc.nextInt();
		System.out.println("Minimum jumps required to reach the end is : " + minJumps(inputArray));
	}
	
	private static int minJumps(int[] inputArray){
		int[] outputArray = new int[inputArray.length];
		outputArray[0] = 0;
		for(int i=0; i<inputArray.length; i++){
			outputArray[i] = i;
			for(int j = 0; j<i; j++){
				if(inputArray[j] + j >= i && outputArray[i] > outputArray[j] + 1)
					outputArray[i] = outputArray[j] + 1;
			}
		}
		printArray(outputArray);
		return outputArray[inputArray.length - 1];
	}
	
	private static void printArray(int[] inputArray){
		for(int i:inputArray)
			System.out.println(i + "\t");
	}

}
