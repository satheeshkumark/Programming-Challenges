package Others;

/*
 * Author : Satheeshkumar Karuppusamy, satheeshusc@gmail.com
 * 
 * Problem : Linked List basic structure along with some functionalities
 * 
*/


public class LinkedList {
	private Node head;
	
	public LinkedList(){
		
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	public void insertAtEnd(int data){
		if(this.getHead() == null){
			this.setHead(new Node(data));
			return;
		}
		Node currentNode = this.getHead();
		while(currentNode.getNext() != null)
			currentNode = currentNode.getNext();
		currentNode.setNext(new Node(data));
		return;
	}
	
	public void printList(){
		Node currentNode = this.getHead();
		while(currentNode != null){
			System.out.print(currentNode.getData() + "\t");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public void makeCircular(){
		Node currentNode = this.getHead();
		if(currentNode == null)
			return;
		while(currentNode.getNext() != null)
			currentNode = currentNode.getNext();
		currentNode.setNext(this.getHead());
	}
}
