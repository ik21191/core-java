package com.mypack.serialization;

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
	
	public Student() {
		
	}
	
	public Student(String name, String city, int roll) {
		this.name = name;
		this.city = city;
		this.roll = roll;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(name);
		out.writeInt(roll);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.name = in.readUTF();
		this.roll = in.readInt();
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
	
	@Override
	public String toString() {
		return "Name: " + name + ", City: " + city + ", roll: " + roll;
	}
}

public class ExternalizableDemo {
	private static final Logger log = Logger.getLogger(ExternalizableDemo.class);
	public static void main(String[] args) throws Exception {
		Student pair = new Student("Imran", "New Delhi", 101);
		log.info("Initially: " + pair.toString());

		// Serialize the pair to a file.
		FileOutputStream outputStream = new FileOutputStream("e://myser.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		pair.writeExternal(objectOutputStream);

		// Close all resources.
		objectOutputStream.flush();
		outputStream.close();

		// Read the contents from the file and create a new instance.
		Student copyOfPair = new Student();

		FileInputStream inputStream = new FileInputStream("e://myser.ser");
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		copyOfPair.readExternal(objectInputStream);

		// Close all resources.
		objectInputStream.close();
		inputStream.close();
		
		log.info("After de-serialization: " + copyOfPair.toString());

	}

}
