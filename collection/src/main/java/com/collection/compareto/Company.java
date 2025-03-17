package com.collection.compareto;

public class Company {
	
	private String name, address;
	private int id;
	
	public Company(String name, String address, int id) {
		super();
		this.name = name;
		this.address = address;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.id + "  " + this.name + "  " + this.address;
	}
	
}
