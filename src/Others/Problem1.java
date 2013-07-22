package Others;

/*
 * @author satheeshkumark
 * 
 * Problem : Check whether the linked list is circular and merging two sorted lists
 * 
 * Runtime : O(n)
 * Space complexity : O(1) - constant space 
*/

public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
		for(int i = 0; i < 10; i++){
			l1.insertAtEnd(i);
			l2.insertAtEnd(i+1);
			i++;
		}
		
		System.out.println("Contents of Linked List 1 : ");
		l1.printList();
		System.out.println("Contents of Linked List 2 : ");
		l2.printList();
		System.out.println("First Merge");
		mergeLists(l1.getHead(),l2.getHead()).printList();
		LinkedList l3 = new LinkedList();
		LinkedList l4 = new LinkedList();
		System.out.println("Second Merge");
		mergeLists(l4.getHead(),l3.getHead()).printList();
		l1.makeCircular();
		System.out.println("Check Circularity : " + checkCircularity(l1.getHead()));
		System.out.println("Check Circularity : " + checkCircularity(l2.getHead()));
		System.out.println("Check Circularity : " + checkCircularity(l3.getHead()));
	}
	
	private static LinkedList mergeLists(Node node1, Node node2){
		LinkedList newList = new LinkedList();
		Node currentNewNode = null;
		Node previousNode = null;
		while(node1 != null || node2 != null){
			if(node1 != null && (node2 == null || node1.getData() <= node2.getData())){
				/*	Creating a new node and move to next node in LinkedList1	*/
				currentNewNode = new Node(node1.getData());
				node1 = node1.getNext();
			}
			else{
				/*	Creating a new node and move to next node in LinkedList2	*/
				currentNewNode = new Node(node2.getData());
				node2 = node2.getNext();
			}
			/*	Set the head of new Linked List only once	*/
			if(previousNode == null)
				newList.setHead(currentNewNode);
			else
				previousNode.setNext(currentNewNode);
			/*	Make the current node as a previous node	*/
			previousNode = currentNewNode;
		}
		return newList;
	}
	
	private static boolean checkCircularity(Node node){
		Node firstPointer = node;
		Node secondPointer = node != null?node.getNext():null;
		if(firstPointer == null || secondPointer == null)
			return false;
		while(firstPointer != null && secondPointer != null){
			if(firstPointer.equals(secondPointer))
				return true;
			firstPointer = firstPointer.getNext();
			secondPointer = secondPointer.getNext().getNext();
		}
		return false;
	}
}
