package Algorithms;
/*
 * @author satheeshkumark
 * 
 * Problem :
 *  Given an array, find the smallest sum greater than zero. You can choose any subset of numbers from the given set. 
 *  A number, irrespective of its polarity in input, can take any polarity
 *  
 * Algorithm : 
 *  Construct a Dynamic Programming Table which constructs the possibility of formation of each value by summing different set of combinations of input Values with either polarities
 *  Traverse the constructed DP Table to find the least possible sum
 * 
 * Runtime: O(nS); n - number of elements in the array; S - maximum positive sum that could be formed
 * Space : O(S): track the possible sum values. It is enough to track positive sums since we need a minimum number greater than zero
 *  
*/  

import java.util.*;
public class PositiveSet{
    private static int setSplit(int A[]){
        if(A == null || A.length == 0) return 0;
        int len = A.length;
        int posSum = 0;
        
        /*	Calculates maximum possible sum	*/
        for(int i = 0; i < len; i++){
            int curr = A[i];
            if(curr < 0){
                curr = -curr;
            }
            posSum += curr;
        }
        /*	Construct boolean table of possible sums	*/
        boolean dp[] = new boolean[posSum + 1];
        dp[0] = true;
        for(int i = 0; i < len; i++){
            int curr = A[i];
            for(int j = posSum; j >= curr; j--){
                if(dp[j - curr]){
                    dp[j] = true;
                }
            }
        }
        
        /*	Traverses the array to get the minimum value	*/
        int mid = posSum/2;
        while(mid >= 0){
            if(dp[mid] == true){
                return Math.abs(posSum - mid - mid);
            }
                mid--;
        }
        return 0;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
        	System.out.println("Enter the length of the array");
            int len = sc.nextInt();
            if(len == 0){
                break;
            }
            int A[] = new int[len];
            System.out.println("Enter the elements");
            for(int i = 0; i < len; i++){
                A[i] = sc.nextInt();
            }
            int res = setSplit(A);
            System.out.println(res);
            break;
        }
    }
}
