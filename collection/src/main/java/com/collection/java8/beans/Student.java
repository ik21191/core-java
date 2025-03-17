package com.collection.java8.beans;

public class Student {
	private int id;
	private String studentName;
	
	public Student(int id, String studentName) {
		this.id = id;
		this.studentName = studentName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Override
	public String toString() {
		return "Student ID: " + id + ", Student Name: " + studentName;
	}
}
