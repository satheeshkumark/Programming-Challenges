package Algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.List;


public class TravellingSalesmanDP {

	/**	
	 * Given n cities find the shortest path to travel from city 0, visit all the cities only once and return to city 0
	 * Solution using Dynamic Programming
	 * Approach : 
	 * For each node, Find n length shortest paths starting at city 0 visiting n-1 cities and then visiting city i
	 * Use those to find n+1 length shortest paths
	 * Runtime : O(n^2 * 2^n)
	 * 
	 */
	
	static double shortestDistance = 100000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		findShortestDistance(distArray, n);
		System.out.println("Shortest Possible round trip distance : " + shortestDistance);
	}
	
	private static void findShortestDistance(int[][] distArray, int n){
		double[][] dpArray = new double[n][n];
		List<Integer>[][] pathList = new ArrayList[n][n];
		List<Integer> shortestPath = null;
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				dpArray[i][j] = Double.POSITIVE_INFINITY;
			}
		}
		
		for(int i=1;i<n;i++){
			dpArray[0][i] = distArray[0][i];
			pathList[0][i] = new ArrayList<Integer>();
			pathList[0][i].add(0);
			pathList[0][i].add(i);
		}
		
		for(int i=1; i<n-1; i++){
			for(int j=1; j<n; j++){
				for(int k=1; k<n; k++){
					ArrayList<Integer> currentPath = (ArrayList<Integer>) pathList[i-1][k];
					if(currentPath != null && !currentPath.contains(j)){
						double currentDistance =  dpArray[i-1][k] + distArray[k][j];
						if(currentDistance < dpArray[i][j]){
							dpArray[i][j] = currentDistance;
							pathList[i][j] = new ArrayList<Integer>(currentPath);
							pathList[i][j].add(j);
						}
					}
				}
			}
		}
		
		for(int i=1;i<n;i++){
			double currentDistance = dpArray[n-2][i] + distArray[i][0];
			if(currentDistance < shortestDistance){
				shortestDistance = currentDistance;
				shortestPath = (ArrayList<Integer>) pathList[n-2][i];
				shortestPath.add(0);
			}
		}
		
		printShortestPath(shortestPath);
	}
	
	private static void printShortestPath(List<Integer> shortestPath){
		if(shortestPath == null){
			System.out.println("Shortest path doesnt exist");
			return;
		}
		String outputString = "";
		for(Integer i : shortestPath){
			outputString += i+"->";
		}
		System.out.println(outputString.substring(0,outputString.length()-2));
	}
}

	
	