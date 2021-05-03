package com.mypack.java8.lambda;

//Functional interface i.e The interface which has only one abstract method
interface Driveable {
	void drive(int value);
}

interface Addable {
	void add(int a, int b);
}
public class LambdaWithParam {

	public static void main(String ar[]) {
		//Single parameter implementation
		Driveable d1 = new Driveable() {
			@Override
			public void drive(int value) {
				System.out.println("Printed through Inner class implementation : " + value);
			}
		};
		d1.drive(100);
		//implementation with lambda expression
		
		Driveable d2 = (value) -> { //(int value) this is also possible
			System.out.println("Printed through lambda expression implementation : " + value);
		};
		
		/*Driveable d2 = value -> { //(int value) this is also possible
			System.out.println("Printed through lambda expression implementation : " + value);
		};*/
		d2.drive(200);
		
		//Multiple parameter implementation
		
		Addable d3 = new Addable() {
			@Override
			public void add(int a, int b) {
				System.out.println("Printed through Inner class implementation : " + (a + b));
			}
		};
		d3.add(100, 100);
		//implementation with lambda expression
		
		Addable d4 = (a, b) -> {
			System.out.println("Printed through lambda expression implementation : " + (a + b));
		};
		d4.add(200, 200);
		
	}
}
