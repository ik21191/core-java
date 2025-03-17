package com.collection.single.link.list;

import org.apache.log4j.Logger;

public class LinkedListOperations {
	private static final Logger log = Logger.getLogger(LinkedListOperations.class);

	private static MyNode myLinkedList;
	public static void main(String[] args) {
		
		MyNode node1 = new MyNode(10);
		MyNode node2 = new MyNode(20);
		MyNode node3 = new MyNode(30);
		MyNode node4 = new MyNode(40);
		MyNode node5 = new MyNode(50);
		MyNode node6 = new MyNode(100);
		MyNode node7 = new MyNode(500);
		
		addAtEnd(node1);
		addAtEnd(node2);
		addAtEnd(node3);
		addAtEnd(node4);
		addAtEnd(node5);
		
		display();
		
		log.info("Adding node at the start");
		
		addAtStart(node6);
		
		display();
		
		log.info("Adding at 3 position ");
		addAtIndex(3, node7);
		
		display();
	}
	
	private static void addAtEnd(MyNode data) {
		if(myLinkedList == null) {
			myLinkedList = data;
			return;
		}
		
		MyNode currentNode = myLinkedList;
		
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		
		currentNode.next = data;
	}
	
	private static void addAtStart(MyNode data) {
		if(myLinkedList == null) {
			myLinkedList = data;
			return;
		}
		data.next = myLinkedList;
		myLinkedList = data;
	}
	
	private static void addAtIndex(int position, MyNode newNode) {
		int count = 1;
		
		MyNode previous = myLinkedList;
		while(count < position -1) {
			previous = previous.next;
			count++;
		}
		MyNode current = previous.next;
		newNode.next = current;
		previous.next = newNode;
	}
	
	private static void display() {
		MyNode currentNode = myLinkedList;//make head node as the first node in the list
		
		while(currentNode.next != null) {//if next node is not null then make next node to current node
			log.info(currentNode.data);
			currentNode = currentNode.next;
		}
		//print last node
		log.info(currentNode.data);
	}

}
