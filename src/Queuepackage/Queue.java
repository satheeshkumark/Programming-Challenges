package Queuepackage;


/*
  * Author : Satheeshkumar Karuppusamy, satheeshusc@gmail.com
  * Problem : Implementation of Queue data structure and its functionalities 
  * 
*/



class Node{
	
	private int value;
	private Node next;
	
	public Node(int element){
		this.value = element;
		this.next = null;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	public void setValue(int element){
		this.value = element;
	}
	
	public void setNext(Node nextNode){
		this.next = nextNode;
	}
}


public class Queue {
	int currentRearPosition;
	int maxQueueSize;
	Node front;
	Node rear;
	int currentQueueSize = 0;
	
	public Queue(int size){
		this.maxQueueSize = size;
		this.currentRearPosition = 0;
		this.front = null;
		this.rear = null;
	}

	public void enQueue(int element){
		if(isQueueEmpty()){
			Node newNode = new Node(element);
			this.front = newNode;
			this.rear = newNode;
			this.currentQueueSize++;
		}
		else{
			if(isQueueFull()){
				System.out.println("SORRY!!! No more elements can be added to the queue. Maximum size of queue :" + maxQueueSize + " Current occupied size:" + currentQueueSize);
			}
			else{
				Node newNode = new Node(element);
				rear.setNext(newNode);
				rear = newNode;
				this.currentQueueSize++;
			}
		}
	}
	
	public int deQueue(){
		if(isQueueEmpty()){
			System.out.println("SORRY!!! Cant dequeue.. The Queue looks Empty!!! The current Size of the Queue :" + currentQueueSize);
			return -1;
		}
		int dequeuedelement = this.front.getValue();
		Node temp;		
		temp = this.front.getNext();
		if(temp ==  null)
			this.rear = null;
		this.front = temp;
		this.currentQueueSize--;
		System.out.println("Dequeued element :"  + dequeuedelement);
		return dequeuedelement;
	}
	
	public void clearQueue(){
		while(this.front != null){
			int element = deQueue();
			System.out.println("The dequeued element value : " + element);			
		}
	}
	
	public boolean isQueueEmpty(){
		if(this.front == null && this.rear == null)	
			return true;
		else
			return false;
	}

	public boolean isQueueFull() {
		if(this.currentQueueSize == this.maxQueueSize)
			return true;
		else
			return false;
	}
	
	public void printQueue(){
		Node temp = front;
		System.out.println("Content of the queue");
		while(temp != null){
			System.out.print(temp.getValue() + " ");
			temp = temp.getNext();
		}
		System.out.println("");
	}
	
	public int getCurrentQueueSize(){
		return this.currentQueueSize;
	}
}
