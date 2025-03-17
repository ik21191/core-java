package com.collection.single.link.list;

public class MyLinkedList {
	
	private static int counter;
	private Node head;

	public MyLinkedList() {
		
	}
	
	// appends the specified element to the end of this list.
	public void add(Object data) {
 
		// Initialize Node only incase of 1st element
		if (head == null) {
			head = new Node(data);
		}
 
		Node temp = new Node(data);
		Node current = head;
 
		// Let's check for NPE before iterate over crunchifyCurrent
		if (current != null) {
 
			// starting at the head node, crawl to the end of the list and then add element after last node
			while (current.getNext() != null) {
				current = current.getNext();
			}
 
			// the last node's "next" reference set to our new node
			current.setNext(temp);
		}
 
		// increment the number of elements variable
		incrementCounter();
	}
	
	// inserts the specified element at the specified position in this list
	public void add(Object data, int index) {
		Node temp = new Node(data);
		Node current = head;
 
		// Let's check for NPE before iterate over crunchifyCurrent
		if (current != null) {
			// crawl to the requested index or the last element in the list, whichever comes first
			for (int i = 0; i < index && current.getNext() != null; i++) {
				current = current.getNext();
			}
		}
 
		// set the new node's next-node reference to this node's next-node reference
		temp.setNext(current.getNext());
 
		// now set this node's next-node reference to the new node
		current.setNext(temp);
 
		// increment the number of elements variable
		incrementCounter();
	}
 
	public Object get(int index)
	// returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if (index < 0)
			return null;
		Node current = null;
		if (head != null) {
			current = head.getNext();
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null)
					return null;
 
				current = current.getNext();
			}
			return current.getData();
		}
		return current;
 
	}
 
	// removes the element at the specified position in this list.
	public boolean remove(int index) {
 
		// if the index is out of range, exit
		if (index < 1 || index > size())
			return false;
 
		Node current = head;
		if (head != null) {
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null)
					return false;
 
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());
 
			// decrement the number of elements variable
			decrementCounter();
			return true;
 
		}
		return false;
	}
 
	private static int getCounter() {
		return counter;
	}
 
	private static void incrementCounter() {
		counter++;
	}
 
	private void decrementCounter() {
		counter--;
	}
	public int size() {
		return getCounter();
	}
	
	public String toString() {
		String output = "";
 
		if (head != null) {
			Node current = head.getNext();
			while (current != null) {
				output += "[" + current.getData().toString() + "]";
				current = current.getNext();
			}
 
		}
		return output;
	}
}

class Node {
	// reference to the next node in the chain, or null if there isn't one.
	Node next;

	// data carried by this node. could be of any type you need.
	Object data;

	// Node constructor
	public Node(Object dataValue) {
		next = null;
		data = dataValue;
	}

	// another Node constructor if we want to specify the node to point to.
	public Node(Object dataValue, Node nextValue) {
		next = nextValue;
		data = dataValue;
	}

	// these methods should be self-explanatory
	public Object getData() {
		return data;
	}

	public void setData(Object dataValue) {
		data = dataValue;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node nextValue) {
		next = nextValue;
	}

}

