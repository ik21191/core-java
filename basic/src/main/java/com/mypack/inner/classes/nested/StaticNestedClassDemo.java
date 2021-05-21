package com.mypack.inner.classes.nested;

public class StaticNestedClassDemo {
	
	public static void outerMethod() {
		System.out.println("outerMethod of StaticNestedClassDemo");
	}

	static class Inner {
		public static void main(String[] args) {
			
			outerMethod();
		}
	}
	
}
