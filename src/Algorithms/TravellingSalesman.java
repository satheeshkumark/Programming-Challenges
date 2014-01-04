package Algorithms;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TravellingSalesman {

	/**
	 * Starts at vertex 0, visits all the nodes only once and returns to vertex 0
	 * Permutes all possible paths and finds the shortest among them
	 * Runtime : O(n!)
	 */
	static int shortestDistance = 10000;
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		int n = sc.nextInt();
		int[][] distArray = new int[n][n];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.println("Enter the value of [" + i +"][" + j + "]");
				distArray[i][j] = sc.nextInt();
			}
		}
		int sourceVertexId = 0;
		Set<Integer> visitedSet = new HashSet<Integer>();
		visitedSet.add(sourceVertexId); 
		findShortestDistance(distArray, sourceVertexId, n, visitedSet, 0);
		System.out.println("Shortest Possible round trip distance : " + shortestDistance);
	}
	
	private static void findShortestDistance(int[][] distArray, int sourceVertexId, int n, Set<Integer> visitedSet, int currentDistance){
		if(visitedSet.size() == n){
			currentDistance = currentDistance + distArray[sourceVertexId][0];
			if(currentDistance < shortestDistance)
				shortestDistance = currentDistance;
			return;
		} 
		for(int i=1;i<n;i++){
			Set<Integer> newVisitedSet = new HashSet<Integer>(visitedSet);
			if(! visitedSet.contains(i)){
				newVisitedSet.add(i);
				findShortestDistance(distArray, i, n, newVisitedSet, currentDistance + distArray[sourceVertexId][i]);
			}
		}
		return;
	}
}
