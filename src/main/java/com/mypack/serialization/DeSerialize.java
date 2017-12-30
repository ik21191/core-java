package com.mypack.serialization;

import java.io.*;

import org.apache.log4j.Logger;

public class DeSerialize {
	private static Logger log = Logger.getLogger(DeSerialize.class);

	public static void main(String arr[]) throws Exception {
		FileInputStream in = new FileInputStream("e://object.ser");
		ObjectInputStream inObject = new ObjectInputStream(in);
		Person p = (Person) inObject.readObject();
		log.info(p);
		inObject.close();
		in.close();
	}
}
