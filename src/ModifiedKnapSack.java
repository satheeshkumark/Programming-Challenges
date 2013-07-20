/*
 * 2013-Jul-03
 * Satheeshkumar Karuppusamy, satheeshusc@gmail.com
 * 
 * Modification of Bell's Algorithm for permutation.
 * Calculates the number of words that could be formed until the required permutation of words is reached
 * Worst Case RunTime Complexity : O(n * n) - Performs n iterations for fixing each character that could match the input String
 * Worst Case Space Complexity : O(n) -linear with n - to track factorial values and duplicates
 * where 'n' is the length of the input String
*/

import java.util.*;
public class ModifiedKnapSack{
    
	public static int findMaximumWeight(int inputArray1[], int inputArray2[], int n){
        int dpTable[] = new int[n]; 
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            dpTable[i] = inputArray2[i];
        }
        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(inputArray1[i] > inputArray1[j])
                    dpTable[i] = Math.max(dpTable[i], dpTable[j] + inputArray2[i]);
            }
            sum = Math.max(sum, dpTable[i]);
        }
        return Math.max(sum, dpTable[0]);
    }
    
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	while(sc.hasNext()){
    		int len = sc.nextInt();
    		if(len == 0)
                break;
            int inputArray1[] = new int[len];
            int inputArray2[] = new int[len];
            for(int i = 0; i < len; i++)
                inputArray1[i] = sc.nextInt();
            for(int i = 0; i < len; i++)
                inputArray2[i] = sc.nextInt();
            System.out.println(findMaximumWeight(inputArray1, inputArray2, len));
            break;
        }
    }
    
}
