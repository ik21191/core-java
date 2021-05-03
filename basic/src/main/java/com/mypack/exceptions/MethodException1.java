package com.mypack.exceptions;

class X1 {

}

class Y {

}

public class MethodException1 {
	public static void display() {
		try {
			int a = 1 / 0;
		} catch (Exception e) {

		} finally {
			System.out.println(new Exception());
		}
		System.out.println("Hello");
	}

	public static void main(String arr[]) {
		display();

		X1 x = new X1();
		X1 y = new X1();
		System.out.println(x == y);
	}
}
