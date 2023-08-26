package com.mypack.java8.function;

import java.util.function.Predicate;

import lombok.Getter;
import lombok.Setter;
public class MyMathPredicate {
  public static void main(String[] args) {
    //Verifying test
	System.out.println(MathFunctions.greaterThan5.test(10));
	//Verifying AND
	//Greater than 5 and Less than 10
	Predicate<Integer> predicate = MathFunctions.greaterThan5.and(MathFunctions.lessThan10);
	//Predicate<Integer> lessThan10 = mathFunctions.getLessThan10();
	System.out.println(predicate.test(11));

	//Test whether A or a is equal
	Predicate<String> compare_a_or_A = MathFunctions.isLower_a.or(MathFunctions.isUpper_A);
	System.out.println("is A: " + compare_a_or_A.test("A"));//True
	System.out.println("is a: " + compare_a_or_A.test("a"));//True
	System.out.println("is z: " + compare_a_or_A.test("z"));//false
	//Test verifying Negation
	Predicate<String> not_a = MathFunctions.isLower_a.negate();
	System.out.println("Not a: " + not_a.test("z"));//true
	System.out.println("Not a: " + not_a.test("a"));//false
	//Anything except A or a
	Predicate<String> not_a_and_not_A = MathFunctions.isLower_a.negate()
			.and(MathFunctions.isUpper_A.negate());
	System.out.println("Not a: " + not_a_and_not_A.test("a"));//false
	System.out.println("Not a: " + not_a_and_not_A.test("A"));//false
	//Predicate.isEqual(Object)
	Predicate<Object> isHello = Predicate.isEqual("Hello").or(Predicate.isEqual("hello"));
	System.out.println(isHello.test("Hello"));
	System.out.println(isHello.test("hello"));
	System.out.println(isHello.test("HELLO"));
  }
}

class MathFunctions {
  public static Predicate<Integer> greaterThan5 = value -> value > 5;
  public static Predicate<Integer> lessThan10 = value -> value < 10;
  public static Predicate<String> isUpper_A = value -> value.equals("A");
  public static Predicate<String> isLower_a = value -> value.equals("a");
}
