package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


class Edge{
	private int sourceNode;
	private int destinationNode;
	private double edgeWeight;
	
	public Edge(int sourceNode, int destinationNode, double edgeWeight){
		this.setSourceNode(sourceNode);
		this.setDestinationNode(destinationNode);
		this.setEdgeWeight(edgeWeight);
	}

	public int getSourceNode() {
		return sourceNode;
	}

	public void setSourceNode(int sourceNode) {
		this.sourceNode = sourceNode;
	}

	public int getDestinationNode() {
		return destinationNode;
	}

	public void setDestinationNode(int destinationNode) {
		this.destinationNode = destinationNode;
	}

	public double getEdgeWeight() {
		return edgeWeight;
	}

	public void setEdgeWeight(double edgeWeight) {
		this.edgeWeight = edgeWeight;
	}
}


public class Dijkstra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Nodes");
		int numberOfNodes = sc.nextInt();
		Map<Integer, List<Edge>> inputGraph = new HashMap<Integer, List<Edge>>();
		double shortestDistance[] = new double[numberOfNodes];
		
		for(int vertexId=0; vertexId<numberOfNodes; vertexId++){
			System.out.println("Enter the number of edges from the vertex " + vertexId);
			int numberOfEdges = sc.nextInt();
			List<Edge> edgeList = new ArrayList<Edge>();
			inputGraph.put(vertexId, edgeList);
			for(int edgeId = 0; edgeId < numberOfEdges; edgeId++){
				System.out.println("Enter the destination vertex");
				int destVertex = sc.nextInt();
				System.out.println("Enter the edge weight");
				int edgeWeight = sc.nextInt();
				Edge currentChildEdge = new Edge(vertexId, destVertex, edgeWeight);
				edgeList.add(currentChildEdge);
			}
			shortestDistance[vertexId] = Double.POSITIVE_INFINITY;
		}
		
		System.out.println("Enter the source vertex Id");
		int sourceVertex = sc.nextInt();

		System.out.println("Enter the target vertex Id");
		int destVertex = sc.nextInt();
		
		shortestDistance[sourceVertex] = 0.0;
		performDijkstra(inputGraph, shortestDistance, sourceVertex, destVertex);
	}
	
	private static void performDijkstra(Map<Integer, List<Edge>> inputGraph, double[] shortestDistance, int sourceVertex, int destVertex){
		boolean visitedNodes[] = new boolean[inputGraph.size()];
		while(sourceVertex != -1){
			List<Edge> outgoingEdges = inputGraph.get(sourceVertex);
			for(Edge edge : outgoingEdges){
				int targetVertex = edge.getDestinationNode();
				double currentDistance = shortestDistance[sourceVertex] + edge.getEdgeWeight(); 
				if(currentDistance < shortestDistance[targetVertex]){
					shortestDistance[targetVertex] = currentDistance;
				}
			}
			visitedNodes[sourceVertex] = true;
			sourceVertex = findVertexWithMinDistance(shortestDistance, visitedNodes);
		}
		System.out.println("Resultant Minimum distance of the entire path : " + shortestDistance[destVertex]);
	}
	
	private static int findVertexWithMinDistance(double[] shortestDistance, boolean[] visitedNodes){
		int minDistNode = -1;
		double minDist = Double.POSITIVE_INFINITY;
		for(int vertexId=0; vertexId < shortestDistance.length; vertexId++){
			if(visitedNodes[vertexId] == false && shortestDistance[vertexId] < minDist){
				minDist = shortestDistance[vertexId];
				minDistNode = vertexId;
			}
		}
		return minDistNode;
	}
}

