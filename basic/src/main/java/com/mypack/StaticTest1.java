package com.mypack;

class A3 {
	public static B3 b = new B3();

	public A3() {
		System.out.println("Constructor of A");
	}
}

class B3 extends A3 {
	public B3() {
		System.out.println("Constructor of B3");
	}

	public void display() {
		System.out.println("display() of B3");
	}
}

public class StaticTest1 {
	public static void main(String[] args) {
		A3.b.display();
		System.out.println("hello");
	}
}