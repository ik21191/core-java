package com.mypack.static1;

public class StaticBlock {

	static {
		try {
			System.out.println("Initializing StaticBlock class...");
			throw new Exception();
		} catch(Exception e) {
			System.out.println("Exception is : " + e);
		}
	}
	
	public static void displayHello() {
		System.out.println("Hello");
	}
}
