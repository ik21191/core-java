package com.mypack.java8.lambda;

//Functional interface i.e The interface which has only one abstract method
interface Drawable {
	void draw();
}

public class LambdaWithoutParam {

	public static void main(String ar[]) {
		final int value = 100;
		//implementation without lambda expression
		Drawable d1 = new Drawable() {
			@Override
			public void draw() {
				System.out.println("Printed through Inner class implementation : " + value);
			}
		};
		d1.draw();
		//implementation with lambda expression
		
		Drawable d2 = () -> {
			System.out.println("Printed through lambda expression implementation : " + value);
		};
		d2.draw();
	}
}
