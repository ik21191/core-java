package com.mypack.annotation;

class A {
	public void display() {
		System.out.println("display() of A");
	}

	@Deprecated
	public String oldMethod() {
		return "do not use this method, please use updated version of this method.";
	}
}

public class Demo2 extends A {
	@Override // without using @Override annotation If parent class would remove
				// the display function then you will never know.
	public void display() {
		System.out.println("display() of Demo2");
	}

	public static void main(String arr[]) {
		A a = new A();
		System.out.println(a.oldMethod());
	}
}
