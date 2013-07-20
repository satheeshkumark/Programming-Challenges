package Algorithms;

/*
 * Satheeshkumar Karuppusamy, satheeshusc@gmail.com
 * 
 * Problem : Construct Binary Search Tree given pre-order traversal as the input
 * 
 * Algorithm: 
 * 	Set maximum and minimum value for every subtree from the current node
 * 			F0r example : node with value 5 can have values than 5 in left and values greater than 5 in the right
 * 						  So left subtree can have maximum = 5, minimum = -infinity
 * 						  Similarly right subtree can have minimum =5, maximum = +infinity
 *	Create a new node when the value of the node can fall within the range of the values set by the predecessors of the current node
 *	Construct the left subtree of the current node
 *	Construct the right subtree of the current node
 * 	Track the current position in the input array 
 * Runtime : O(n)
 * Space complexity : O(1) - no extra space needed
*/

import java.util.Scanner;


public class BST {
	private Node root;
	private static int position = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int inputLength = sc.nextInt();
		int inputArray[] = new int[inputLength];
		int i = 0;
		System.out.println("Enter the input array");
		while(i <inputLength){
			inputArray[i] = sc.nextInt();
			i += 1;
		}
		BST t1 = new BST();
		t1.setRoot(constructTree(inputArray,Integer.MAX_VALUE,Integer.MIN_VALUE));
		System.out.println("Done with tree construction");
		printPreorder(t1.getRoot());
	}
	
	/*	Prints the elements in the binary search tree by pre-order traversal	*/
	
	private static void printPreorder(Node root){
		if(root == null)
			return;
		System.out.println(root.getData());
		printPreorder(root.getLeft());
		printPreorder(root.getRight());
	}
	
	/*	constructs tree from pre-order traversal	*/
	
	private static Node constructTree(int[] inputArray, int max, int min){
		int currentPosition = getPosition();
		if(getPosition() == inputArray.length)
			return null;
		Node newnode = null;
		/*	checks if the value of the current node is in the current range of values of current sub tree	*/
		if(inputArray[currentPosition] > min && inputArray[currentPosition] < max){
			newnode = new Node();
			newnode.setData(inputArray[currentPosition]);
			position += 1;
			newnode.setLeft(constructTree(inputArray, inputArray[currentPosition], Integer.MIN_VALUE));
			newnode.setRight(constructTree(inputArray, Integer.MAX_VALUE, inputArray[currentPosition]));
		}
		return newnode;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public static int getPosition() {
		return position;
	}

	public static void setPosition(int position) {
		BST.position = position;
	}
}
