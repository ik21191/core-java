package com.mypack.objectclass;

import org.apache.log4j.Logger;

public class CloneDemo {
	private static final Logger log = Logger.getLogger(CloneDemo.class);
	public static void main(String[] args) {
		Address address = new Address("New Delhi", "India");
		Student student1 = new Student("Imran Khan", address);
		try {
			Student student2 = (Student)student1.clone();
			student2.getAddress().setCountry("USA");
			log.info("student1's country name: " + student1.getAddress().getCountry());
			log.info("student2's country name: " + student2.getAddress().getCountry());
		} catch(Exception e) {
			log.error(e);
		}
	}
}
