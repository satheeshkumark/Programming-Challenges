package Algorithms;
/* 2013-Jul-15
 * Author : Satheeshkumar Karuppusamy
 * Problem : Dutch National Flag Problem or Three way partitioning
 * Algorithm :
 	 * Accumulate the Partition3 values in the left and right corners of the array
	 * Accumulate the Partition1 values in left side of the array but right to Partition3 values encountered by i
	 * Accumulate the Partition2 values in right side of the array but left to Partition3 values encountered by j
	 * Move the Partition3 values to the middle		
 * Runtime : O(n)
 * Space Complexity : O(1) in-place swapping
 */

import java.util.Scanner;


public class DutchFlag {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number");
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] inputArray = new int[length];
		int i = 0;
		System.out.println("Enter the input Array");
		while(i<length){
			inputArray[i] = sc.nextInt();
			i++;
		}
		System.out.println("Enter the boundary value for Parition 1");
		int lowValue = sc.nextInt();
		System.out.println("Enter the boundary value for Partition 2");
		int highValue = sc.nextInt();
		dutchFlagSort(inputArray, lowValue, highValue);
	}
	
	/*
	 * Partition1 - elements <lowValue
	 * Partition2 - elements > highValue
	 * Partition3 - elements >= lowValue and elements <=highValue
	 * i  - pointer moving from left
	 * j - pointer moving from right
	 * lP - left Pivot index tracker
	 * rP - right Pivot index tracker
	 * 
	 * Algorithm : 
	 * Accumulate the Partition3 values in the left and right corners of the array
	 * Accumulate the Partition1 values in left side of the array but right to Partition3 values encountered by i
	 * Accumulate the Partition2 values in right side of the array but left to Partition3 values encountered by j
	 * Move the Partition3 values to the middle
	 */
	
	public static void dutchFlagSort(int[] arr, int lowValue, int highValue) {
        int i =0 ;
        int j = arr.length - 1;
        int lP = 0;
        int hP = arr.length - 1;
        
        while(i <= j){
        	if(arr[i] > highValue){
        		if(arr[j] < lowValue){
        			swap(arr, i, j);
        			i++;
        			j--;
        		}
        		else if(arr[j] > lowValue){
        			j--;
        		}
        		else{
        			swap(arr, hP, j);
        			j--;
        			hP--;
        		}
        	}
        	else if(arr[i] < lowValue){
        		i++;
        	}
        	else{
        		swap(arr, i, lP);
        		lP++;
        		i++;
        	}
        }
        
        System.out.println("Before paritioning");
        for(int outputvalue : arr){
        	System.out.println(outputvalue);
        }
        int k = 0;
        while(k<lP){
        	swap(arr,k,j);
        	k++;
        	j--;
        }
        k = arr.length - 1;
        while(k>hP){
        	swap(arr,k,i);
        	k--;
        	i++;
        }
        
        System.out.println("After Partioning");
        
        for(int outputvalue : arr){
        	System.out.println(outputvalue);
        }
    }
 
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
