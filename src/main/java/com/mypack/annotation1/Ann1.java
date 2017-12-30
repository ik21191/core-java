package com.mypack.annotation1;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnn1 
{
	String name() default "abc";
	int roll() default 101;
}
public class Ann1
{
	@MyAnn1(name="Imran")
	public static void display(String name,int a)
	{
		System.out.println("display() of Ann1 and value of a is :"+a);
	}
	public static void main(String arr[])throws Exception
	{
		Class<Ann1> cl=Ann1.class;
		Class c[]=new Class[]{String.class,int.class};
		Method m=cl.getMethod("display", c);
		Object o=new Ann1();
		if(m.isAnnotationPresent(MyAnn1.class))
		{
			Annotation an[]=m.getAnnotations();
			System.out.println();
			System.out.println("Annotation is present");
			m.invoke(o,new Object[]{"Imran Khan",100});
		}
		else
			System.out.println("Not mapped to any Annotation");
	}
}