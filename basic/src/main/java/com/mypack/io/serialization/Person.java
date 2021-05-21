package com.mypack.io.serialization;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class Person implements Serializable {
	private static final long serialVersionUID = 123456780L;

	private static final Logger log = Logger.getLogger(Person.class); 
	private Address add;
	private String name;
	/***
	 * Static field is not serialized because it belongs to class not the object.
	 */
	public static String staticField;
	
	
	public Person() {
		log.info("Person() default constructor is called.");
	}

	public Person(String name, Address add) {
		this.name = name;
		this.add = add;
		System.out.println("Person Parameterized consturtor is called ");
	}

	public String toString() {
		log.info("toString() is called");
		return "Person Name: " + name + "\tPerson Address: " + add.name + "\t staticField : " + staticField;
	}

}
