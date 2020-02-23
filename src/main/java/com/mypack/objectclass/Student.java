package com.mypack.objectclass;

class Address {
	private String city;
	private String country;
	
	public Address(String city, String country) {
		this.city = city;
		this.country = country;
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
}

class CategoryType {
	protected String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}

public class Student extends CategoryType implements Cloneable  {
	private String name;
	private Address address;
	
	public Student(String catetoryName, String name, Address address) {
		this.categoryName = catetoryName;
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/**@Override//example of shallow copy
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}*/
	
	@Override//example of deep copy
	protected Object clone() throws CloneNotSupportedException {
		Student student = (Student)super.clone();
		
		Address newAddress = new Address(student.getAddress().getCity(), student.getAddress().getCountry());
		student.setAddress(newAddress);
		return student;
	}
}