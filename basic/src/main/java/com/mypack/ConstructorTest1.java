package com.mypack;

class X2 {
	public X2() {
		System.out.println("Constructor X2");
	}
}

class Y2 {
	public Y2() {
		System.out.println("Constructor Y2");
	}
}

class A2 {
	public A2() {
		System.out.println("Constructor A2");
	}
}

class B2 extends A2 {
	public B2() {
		System.out.println("Constructor B2");
	}
}

class C2 extends B2 {
	public C2() {
		System.out.println("Constructor C2");
	}

	public C2(int a) {
		System.out.println("Constructor(int) C2");
	}
}

public class ConstructorTest1 extends C2 {
	private X2 x2 = new X2();
	private Y2 y2 = new Y2();

	public ConstructorTest1() {
		// this(10);
		System.out.println("Constructor Test1");
	}

	public ConstructorTest1(int a) {
		// super(10);
		System.out.println("Constructor(int) Test1");
	}

	public static void main(String[] args) {
		ConstructorTest1 t1 = new ConstructorTest1();
	}
}
