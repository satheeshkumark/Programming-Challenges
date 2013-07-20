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
	
	private static void printPreorder(Node root){
		if(root == null)
			return;
		System.out.println(root.getData());
		printPreorder(root.getLeft());
		printPreorder(root.getRight());
	}
	
	private static Node constructTree(int[] inputArray, int max, int min){
		int currentPosition = getPosition();
		if(getPosition() == inputArray.length)
			return null;
		Node newnode = null;
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
