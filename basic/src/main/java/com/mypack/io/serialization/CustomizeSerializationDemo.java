package com.mypack.io.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 123456789L;
	private Long empId;
	private String name;
	//We can save value of this field using customized serialization
	transient private String dob;
	
	public Employee() {
		super();
		System.out.println("Employee() default constructor is called.");
	}
	
	public Employee(Long empId, String name, String dob) {
		super();
		System.out.println("Employee() parameterized constructor is called.");
		this.empId = empId;
		this.name = name;
		this.dob = dob;
	}
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	// this method is executed by jvm when writeObject() on
    // Employee object reference in main method is
    // executed by jvm.
	private void writeObject(ObjectOutputStream os) { 
		try {
			 // to perform default serialization of Employee object.
			os.defaultWriteObject();
			//writing dob to serialize object
			os.writeObject(dob);
		} catch (Exception e) {
			System.out.println(e);
		} 
	}
	
	// this method is executed by jvm when readObject() on
    // Employee object reference in main method is executed by jvm.
	private void readObject(ObjectInputStream in) {
		try {
			// performing default deserialization of Employee object
			in.defaultReadObject();
			// deserializing the dob from the file
			dob = (String)in.readObject();
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	@Override
	public String toString() {
		return "empId: " + empId + ", name: " + name + ", dob: " + dob;
	}
	
}
public class CustomizeSerializationDemo {

	public static void main(String[] args) {
		Employee employee = new Employee(1001L, "Imran Khan", "16-05-84");
		saveObject(employee);
		readObject();
	}

	private static void saveObject(Serializable object) {
		Employee employee = (Employee)object;
		try (FileOutputStream out = new FileOutputStream("d://object.ser");
				ObjectOutputStream objectOut = new ObjectOutputStream(out);) {
			
			System.out.println("Serializing object state...........");
			System.out.println("Before Serialization : hashCode() : " + employee.hashCode());
			objectOut.writeObject(employee);
			
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Saved.");
	}
	
	private static void readObject() {
		try (FileInputStream in = new FileInputStream("d://object.ser");
				ObjectInputStream inObject = new ObjectInputStream(in);) {
			Employee employee = (Employee)inObject.readObject();
			System.out.println("After deserilization hashCode() " + employee.hashCode());
			System.out.println(employee);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
