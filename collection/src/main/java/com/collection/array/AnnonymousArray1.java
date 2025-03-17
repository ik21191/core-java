package com.collection.array;

import org.apache.log4j.Logger;

public class AnnonymousArray1 {
	private static final Logger log = Logger.getLogger(AnnonymousArray1.class);

	public static void display(String myNames[]) {
		log.info("In display() method...........");
		log.info(myNames[0]);
		log.info(myNames[1]);
	}

	public static void main(String arr[]) {
		String names[] = new String[] { "Imran Khan", "Vinay Kumar", "Chandan Trikha" };
		log.info(names[0]);
		log.info(names[1]);
		log.info(names[2]);
		display(names);
	}
}
