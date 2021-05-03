package com.mypack.java8.function.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class Test {
	
	static class IntPredicates {
		public static boolean isOdd(Integer n) { return n % 2 != 0; }
		public static boolean isEven(Integer n) { return n % 2 == 0; }
		public static boolean isPositive(Integer n) { return n >= 0; }
	}
	
	public static void main(String ar[]) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		
		list.forEach(e->{
				System.out.println(e);
			});
		//list.forEach(System.out::println);
		
		//Before Java8 start
		/*Predicate<Integer> isOdd = new Predicate<Integer>() {
			@Override
			public boolean test(Integer number) {
				return IntPredicates.isOdd(number);
			}
		};
		System.out.println(isOdd.test(1));
		*/
		//Before Java8 end
		
		//Using Lamda start
		/*Predicate<Integer> isOdd = number -> IntPredicates.isOdd(number);
		System.out.println(isOdd.test(1));*/
		//Using Lamda end
		
		//Using static method call reference start
		Predicate<Integer> isOdd = IntPredicates::isOdd;
		System.out.println(isOdd.test(1));
		//Using method call reference end
		
	}

}
