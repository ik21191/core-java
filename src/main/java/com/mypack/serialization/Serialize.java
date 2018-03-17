package com.mypack.serialization;

import java.io.*;

import org.apache.log4j.Logger;

public class Serialize {
	private static final Logger log = Logger.getLogger(Serialize.class);

	public static void main(String arr[]) throws Exception {
		Address a1 = new Address("Shalimar Bagh");
		Person p1 = new Person("Imran Khan", a1);
		Person.staticField = "Static field 1";
		Address a2 = new Address("Azad Pur");
		Person p2 = new Person("Vinay Kumar", a2);
		FileOutputStream out = new FileOutputStream("e://object.ser");
		ObjectOutputStream objectOut = new ObjectOutputStream(out);

		log.info("Serializing object state...........");
		log.info("Before Serialization : hashCode() : " + p1.hashCode());
		objectOut.writeObject(p1);
		objectOut.writeObject(p2);
		log.info("Saved.");

		objectOut.close();
		out.close();
	}
}
