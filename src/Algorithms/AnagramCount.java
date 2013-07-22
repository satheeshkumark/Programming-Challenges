package Algorithms;
/*
 * 2013-Jul-03
 * @author satheeshkumark
 * 
 * Problem : Count the lexicographical position of the given word among all the permutations of the characters in the given word
 * 
 * Modification of Bell's Algorithm for permutation.
 * Calculates the number of words that could be formed until the required permutation of words is reached
 * Worst Case RunTime Complexity : O(n * n) - Performs n iterations for fixing each character that could match the input String
 * Worst Case Space Complexity : O(n) -linear with n - to track factorial values and duplicates
 * where 'n' is the length of the input String
*/


import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class AnagramCount {
	static Map<Integer, BigInteger> factMap = new TreeMap<Integer, BigInteger>();
	static BigInteger count = BigInteger.ZERO;
	
	/**
	 * @param args
	 * Performs 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the input");
		Scanner sc = new Scanner(System.in);
		String inputString = sc.next();
		long startTime = System.currentTimeMillis();
		findPermutations(inputString);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Run Time (in milliseconds) : " + totalTime);
	}
	
	public static void findPermutations(String inputString){
		char[] word = inputString.toCharArray();
		Arrays.sort(word);
		int i = 0;
		int j = 0;
		while(i<word.length){
			if(word[i] != inputString.charAt(j)){
				count = count.add(countPermutations(word, i));
				for(int k=i; k<word.length; k++){
					if((int)word[k] > (int)word[i]){
						char temp = word[i];
						word[i] = word[k];
						word[k] = temp;
						break;
					}
				}
			}
			else if(word[i] == inputString.charAt(j)){
				i += 1;
				j += 1;
			}
		}
		System.out.println("Index of the word " + inputString + " : " + count.add(BigInteger.ONE).toString());
	}
	
	/*
	 * Gets the word array which contains individual characters and the current position of the string which is fixed
	 * Finds the possible PERMUTATION OF WORDS WITH THE CHARACTER 'x'(any character) at the start position  
	 */
	
	public static BigInteger countPermutations(char[] word, int startPosition){
		Map<Character, Integer> duplicateCountMap = new HashMap<Character, Integer>();
		for(int i = startPosition + 1; i<word.length; i++){
			if(duplicateCountMap.get(word[i]) == null){
				duplicateCountMap.put(word[i], 1);
			}
			else{
				duplicateCountMap.put(word[i], duplicateCountMap.get(word[i]) + 1);
			}
		}
		BigInteger numerator = factorial(word.length - startPosition - 1);
		BigInteger denominator = BigInteger.ONE;
		for(Integer value : duplicateCountMap.values()){
			denominator = factorial(value).multiply(denominator);
		}
		return numerator.divide(denominator);
	}
	
	
	/* 
	 * FACTORIAL CALCULATION WITH MEMOIZATION
	 * Gets the number as input and returns its Factorial value
	 */
	
	public static BigInteger factorial(int number){
		if(number <= 1)
			return BigInteger.ONE;
		if(factMap.get(number) == null){
			factMap.put(number, BigInteger.valueOf(number).multiply(factorial(number - 1)));
		}
		return factMap.get(number);
	}
}
