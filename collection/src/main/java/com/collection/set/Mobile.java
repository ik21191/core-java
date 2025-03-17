package com.collection.set;

public class Mobile implements Comparable<Mobile>{

	private String name;
	private int id;
	
	public Mobile(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	@Override
	public int compareTo(Mobile mobile) {
		System.out.println("compareTo(Object object) is called..");
		return this.getId() - mobile.getId();
	}
	
	@Override
	public int hashCode() {
		System.out.println("hashCode() of Mobile is called..");
		return 1;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals(Object ) of Mobile is called..");
		return false;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.id + "   " + this.name;
	}
}
