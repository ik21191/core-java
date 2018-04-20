package com.mypack.objectclass;

import org.apache.log4j.Logger;

class Student {
	private String name;
	private String city;
	private String country;
	
	public Student(String name, String city, String country) {
		super();
		this.name = name;
		this.city = city;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Student(this.name, this.city, this.country);
	}
}

public class CloneDemo {
	private static final Logger log = Logger.getLogger(CloneDemo.class);
	public static void main(String[] args) {
		Student student1 = new Student("Imran", "New Delhi", "India");
		try {
			Student student2 = (Student)student1.clone();
			student2.setName("Gautam Kumar");
			log.info("Origional name: " + student1.getName());
			log.info("Clone name: " + student2.getName());
		} catch(Exception e) {
			log.error(e);
		}
	}
}
