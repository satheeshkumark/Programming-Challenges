package Queuepackage;

/*
 * @author satheeshkumark
 * 
 */

public class TestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sizeOfQueue = Integer.parseInt(args[0]);
		int dequeuedvalue = -1;
		int currentQueueSize = 0;
		
		//-------------------Creating a Queue with size as mentioned in sizeOfQueue variable-------------------
		
		System.out.println("Creating a queue with size " + sizeOfQueue);
		Queue integerQueue = new Queue(sizeOfQueue);
		
		//------------------- Pushing values on to the Queue -----------------------------------------------
		
		System.out.println("Pushing values in to the Queue");
		currentQueueSize = integerQueue.getCurrentQueueSize();
		System.out.println("Current size of the queue : " + currentQueueSize);
		for(int i=0; i<sizeOfQueue; i++){
			integerQueue.enQueue(i);
		}
		
		System.out.println("All the elements are pushed into the queue");
		currentQueueSize = integerQueue.getCurrentQueueSize();
		System.out.println("Current size of the queue after the elements are pushed: " + currentQueueSize);
		integerQueue.printQueue();

		System.out.println("");
		System.out.println("Trying to push an element into the Queue even after the queue has reached its maximum capacity");
		integerQueue.enQueue(6);				
		integerQueue.printQueue();		 
		
		//--------------------------Removing all the elements from the queue
		System.out.println("");
		System.out.println("Removing elements from the queue one by one");
		currentQueueSize = integerQueue.getCurrentQueueSize();
		System.out.println("Current size of the queue before removal: " + currentQueueSize);
		for(int i=0; i<currentQueueSize; i++){
			dequeuedvalue = integerQueue.deQueue();
			System.out.println("Dequeued element : " + dequeuedvalue);
			integerQueue.printQueue();
		}
		
		System.out.println("All the elements are dequeued");
		currentQueueSize = integerQueue.getCurrentQueueSize();
		System.out.println("Current size of the queue : " + currentQueueSize) ;
		
		//--------------------------Removing an element from an empty queue		
	
		System.out.println("");
		System.out.println("Removing elements from the empty queue");
		currentQueueSize = integerQueue.getCurrentQueueSize();
		System.out.println("Current size of the queue : " + currentQueueSize) ;
		dequeuedvalue = integerQueue.deQueue();
		
		System.out.println("Pushing values in to the Queue Again");
		currentQueueSize = integerQueue.getCurrentQueueSize();
		System.out.println("Current size of the queue : " + currentQueueSize);
		for(int i=0; i<sizeOfQueue; i++){
			integerQueue.enQueue(i);
		}
		currentQueueSize = integerQueue.getCurrentQueueSize();
		System.out.println("Current size of the queue after the elements are inserted : " + currentQueueSize);
		integerQueue.printQueue();
	}
}
