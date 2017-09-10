
/**
 * This class implements a linked-list based queue.
 * Homework 1 - Part 1
 * DUE: 09.20.2017
 */
public class ListQueue {
	private class Node{
		public String data;
		public Node next;
		
		public Node() {
			this.data = null;
			this.next = null;
		}
		
		public Node(String someData) {
			this.data = someData;
			this.next = null;
		}
	}
	
	//Class variables here, if necessary 
	private Node front;
	private Node back; 
	
	public ListQueue(){
		front = new Node();
		back = front;
	}
	
	public void enqueue(String toInput) {
		Node newNode = new Node(toInput);
		if (front == null || front.data == null) { //when queue is empty or when the front is empty
			front = newNode; //the new element becomes the front	
			back = front;
		}
		else {
			back.next = newNode;
			back = back.next;
		}
	}
	
	public String dequeue(){
		if (front == null) //when queue is empty
			return null;
		
		else if (front != null && back == front) {//when queue has only one element (this one element may or may NOT have data)
			String toRemove = front.data;
			front = null;
			back = null;
			return toRemove;
		}
		
		else { //when queue has at least 2 elements: only front is updated, back is intact
			String toRemove = front.data;
			front = front.next;
			return toRemove;
		}
	}
	
	public String front(){
		//when a new queue is created, the "front" exists and front() will return its data, which equals NULL.
		//however, if for some reason dequeue() is called and removes even this "front", "front" itself is NULL.
		//hence we need this if branch:
		if (front == null) //to account for the case where even the first element is deleted
			return null;
		else
			return front.data;
	}
	
	public String traverseToString(){
		String result = "";
		Node current = front;
		while (current != null) {//while queue still has element(s)
			result += current.data;
			if (current.next != null)
				result += ", ";
			else 
				result += ".";
			current = current.next;
		}
		return result;
	}

}
