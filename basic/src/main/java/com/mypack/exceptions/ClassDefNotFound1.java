package com.mypack.exceptions;

public class ClassDefNotFound1 {
	static {
		new Abc();
	}
	public static void main(String[] args) {
		System.out.println("hello");
	}
}

class Abc {
	public Abc() {
		try {
			Class<?> a = Class.forName("xxx");
			Abc abc = (Abc) a.newInstance();
			System.out.println(abc);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
