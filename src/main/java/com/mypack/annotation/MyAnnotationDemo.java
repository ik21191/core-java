package com.mypack.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
enum MyPriority {
	LOW, MEDIUM, HIGH
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
	String authorName();
	int age() default 32;
	String[] hobbies();
	MyPriority priority();
}

public class MyAnnotationDemo {
	@MyAnnotation(authorName = "Imran Khan", age = 32, hobbies = {"Reading", "Coding"}, priority = MyPriority.LOW)
	public static void toDisplay() {
		System.out.println("toDisplay() of Demo1");
	}

	public static void toPrint() {
		System.out.println("toPrint() of Demo1");
	}

	public static void showAnnotationInfo() throws Exception {
		MyAnnotationDemo demo = MyAnnotationDemo.class.newInstance();
		try {
			Class<? extends MyAnnotationDemo> c = demo.getClass();
			Method m1 = c.getMethod("toDisplay");
			Method m2 = c.getMethod("toPrint");
			
			System.out.println("Checking whether the annotation is present or not on toPrint() method......");
			System.out.println("-------------------------------------");
			if (m2.isAnnotationPresent(MyAnnotation.class))
				System.out.println("YES");
			else
				System.out.println("NO");
			System.out.println("-------------------------------------");
			
			MyAnnotation myAnnotation = m1.getAnnotation(MyAnnotation.class);
			
			System.out.println("Printing MyAnnotation informations.........");
			String authorName = myAnnotation.authorName();
			int age = myAnnotation.age();
			String[] hobbies = myAnnotation.hobbies();
			MyPriority priority = myAnnotation.priority();
			System.out.println("authorName: " + authorName);
			System.out.println("age: " + age);
			System.out.println("hobbies: " + hobbies[0]);
			System.out.println("priority: " + priority);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String arr[]) throws Exception {
		toDisplay();
		showAnnotationInfo();
	}

}
