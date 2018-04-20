package com.mypack.exceptions;

class MyException extends Exception {
	public String toString() {
		return "This is MyException.";
	}

	public MyException() {
		super();
	}

	public MyException(String s) {
		super(s);
	}

	public void display() {
		System.out.println("in display() method.");
		try {
			throw new MyException("User defined exception");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Code written after thrown an exception.");
	}

	public void print() throws Exception {
		System.out.println("Imran Khan");
	}
}

public class UserDefinedException1 {
	public static void main(String arr[]) {
		MyException me = new MyException();
		me.display();
		// me.print();
	}
}
