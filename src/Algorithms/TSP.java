package Algorithms;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TSP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of nodes");
		int n = sc.nextInt();
		int costMatrix[][] = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.println("Enter the values for " + i + "  " + j);
				costMatrix[i][j] = sc.nextInt();
			}
		}
		int startVertex = 0;
		printCostMatrix(costMatrix);
		System.out.println("The shortest ditanace for TSP is : " + solveTSP(costMatrix, startVertex));
	}
	
	private static void printCostMatrix(int[][] costMatrix){
		for(int i=0;i<costMatrix.length;i++){
			for(int j=0;j<costMatrix[0].length;j++){
				System.out.print(costMatrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	private static int solveTSP(int[][] costMatrix, int startVertex){
		int dpTable[][] = new int[costMatrix.length + 1][costMatrix.length];
		Set<Integer> visitedNodes[][] = new HashSet[costMatrix.length + 1][costMatrix.length];
		for(int i=0;i<costMatrix.length;i++){
			dpTable[0][i] = 0;
		}
		for(int i=0;i<costMatrix.length;i++){
			dpTable[1][i] = costMatrix[0][i];
			visitedNodes[1][i] = new HashSet<Integer>();
			visitedNodes[1][i].add(new Integer(i));
		}
		for(int i=2;i<costMatrix.length;i++){
			for(int j=1;j<costMatrix.length;j++){
				dpTable[i][j] = 1000;
				visitedNodes[i][j] = new HashSet<Integer>();
				int currentMinNode = -1;
				for(int k=1;k<costMatrix.length;k++){
					int currentCost = 0;
					if(k == j)
						continue;
					if(costMatrix[j][k] != -1)
						currentCost = dpTable[i-1][k] + costMatrix[k][j];
					if(dpTable[i][j] > currentCost && !visitedNodes[i-1][k].contains(j)){
						dpTable[i][j] = currentCost;
						currentMinNode = k;
					}
				}
				if(currentMinNode != -1){
					for(Integer x : visitedNodes[i-1][currentMinNode]){
						visitedNodes[i][j].add(x);
					}
					visitedNodes[i][j].add(j);
				}
			}
		}
		dpTable[costMatrix.length][startVertex] = 1000;
		for(int i=0;i<costMatrix.length;i++){
			if(i == startVertex)
				continue;
			int currentCost = dpTable[costMatrix.length - 1][i] + costMatrix[i][startVertex];
			if(dpTable[costMatrix.length][startVertex] > currentCost)
				dpTable[costMatrix.length][startVertex] = currentCost;
		}
		System.out.println();
		System.out.println("Cost Matrix");
		printCostMatrix(dpTable);
		return dpTable[costMatrix.length][startVertex];
	}
}
