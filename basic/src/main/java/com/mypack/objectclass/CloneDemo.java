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

class Student extends CategoryType implements Cloneable  {
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
    System.out.println("Clonning using deep copy.\n");
      Student student = (Student)super.clone();
      
      Address newAddress = new Address(student.getAddress().getCity(), student.getAddress().getCountry());
      student.setAddress(newAddress);
      return student;
  }
}
