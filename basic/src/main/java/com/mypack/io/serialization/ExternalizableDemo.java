package com.mypack.io.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

class Student implements Externalizable {
	
	private String name;
	private String city;
	private int roll;
	private String password = "12345";
	
	public Student() {
		System.out.println("Student() default constructor is called.");
	}
	
	public Student(String name, String city, int roll) {
		this.name = name;
		this.city = city;
		this.roll = roll;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(roll);
		out.writeObject("");
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.name = (String)in.readObject();
		this.roll = in.readInt();
		this.password = (String)in.readObject();
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
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", City: " + city + ", roll: " + roll + ", password: " + password;
	}
}

public class ExternalizableDemo {
	private static final Logger log = Logger.getLogger(ExternalizableDemo.class);
	public static void main(String[] args) throws Exception {
		Student pair = new Student("Imran", "New Delhi", 101);
		log.info("Initially: " + pair.toString());

		// Serialize the pair to a file.
		FileOutputStream outputStream = new FileOutputStream("d://myser.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(pair);
		
		// Close all resources.
		objectOutputStream.flush();
		outputStream.close();

		// Read the contents from the file and create a new instance.
		
		FileInputStream inputStream = new FileInputStream("d://myser.ser");
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		Student student = (Student)objectInputStream.readObject();
		// Close all resources.
		objectInputStream.close();
		inputStream.close();
		
		log.info("After de-serialization: " + student);

	}

}
