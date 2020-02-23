package com.mypack.objectclass;

import org.apache.log4j.Logger;

public class CloneDemo {
	private static final Logger log = Logger.getLogger(CloneDemo.class);
	public static void main(String[] args) {
		Address address = new Address("New Delhi", "India");
		Student student1 = new Student("School", "Imran Khan", address);
		student1.setCategoryName("School");
		try {
			Student student2 = (Student)student1.clone();
			
			System.out.println(student1);
			System.out.println(student2);
			
			
			student2.getAddress().setCountry("USA");
			student2.setCategoryName("College");
			
			log.info("student1's country name: " + student1.getAddress().getCountry());
			log.info("student1's category name: " + student1.getCategoryName());
			log.info("student2's country name: " + student2.getAddress().getCountry());
			log.info("student2's catetory name: " + student2.getCategoryName());
		} catch(Exception e) {
			log.error(e);
		}
	}
}
