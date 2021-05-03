package com.mypack.java8.misc;

interface DefaultMethodInterface {
	
	default void myDefaultMethod() {
		System.out.println("This is my default method called ..");
	}
	
	void myMethod();
}

public class DefaultMethodDemo implements DefaultMethodInterface {
	
	@Override
	public void myMethod() {
		System.out.println("myMethod() is called...");
	}
	@Override
	public void myDefaultMethod() {
		System.out.println("My overloaded myDefaultMethod() called..");
	}
	public static void main(String[] args) {
		DefaultMethodDemo defaultMethodDemo = new DefaultMethodDemo();
		defaultMethodDemo.myDefaultMethod();
		defaultMethodDemo.myMethod();
	}

}
