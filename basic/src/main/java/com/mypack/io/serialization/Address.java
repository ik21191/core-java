package com.mypack.io.serialization;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class Address implements Serializable {
	private static final Logger log = Logger.getLogger(Address.class); 
	private static final long serialVersionUID = 3344556789L;

	String name;
	
	public Address() {
		log.info("Address() default constructor is callled.");
	}

	public Address(String name) {
		this.name = name;
	}
}
