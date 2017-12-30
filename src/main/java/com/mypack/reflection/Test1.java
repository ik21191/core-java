package com.mypack.reflection;

import java.lang.reflect.Method;

class A
{
	public void display(String name)
	{
		System.out.println("method: display() of A  ||    name is:  "+name);
	}
	public static void print(String name)
	{
		System.out.println("method: print() of A  ||    name is:  "+name);
	}
}
public class Test1 
{
	public static void main(String[] args)throws Exception 
	{
		Class classA=A.class;
		Object a=Class.forName("mypack.A");
		Method method=classA.getMethod("print", String.class);
		method.invoke(null,"imran khan");
	}

}
