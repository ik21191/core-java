package com.collection.single.link.list;

import org.apache.log4j.Logger;

public class SimpleDemo {
	
	private static final Logger log = Logger.getLogger(SimpleDemo.class);
	
	public static void main(String arr[]) {
		//create four separate node
		
		MyNode node1 = new MyNode(10);
		MyNode node2 = new MyNode(2);
		MyNode node3 = new MyNode(5);
		MyNode node4 = new MyNode(20);
		
		//linked them in the form 10->2->5->20->null
		
		MyNode head = node1;
		node1.next = node2; //10->2
		node2.next = node3; //10->2->5
		node3.next = node4; //10->2->5-20->null
		
		MyNode currentNode = head;//make head node as the first node in the list
		
		while(currentNode.next != null) {//if next node is not null then make next node to current node
			log.info(currentNode.data);
			currentNode = currentNode.next;
		}
		//print last node
		log.info(currentNode.data);
	}

}
