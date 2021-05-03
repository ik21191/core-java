package com.mypack.constructor;
class X
{
	public X()
	{
		System.out.println("Constructor X");
	}
}
class Y
{
	public Y()
	{
		System.out.println("Constructor Y");
	}
}
class A
{
	public A()
	{
		System.out.println("Constructor A");
	}
}
class B extends A
{
	public B()
	{
		System.out.println("Constructor B");
	}
}
class C extends B
{
	public C()
	{
		System.out.println("Constructor C");
	}
	public C(int a)
	{
		System.out.println("Constructor(int) C");
	}
}
public class Test1 extends C
{
	private X x=new X();
	private Y y=new Y();
	public Test1()
	{
		//this(10);
		System.out.println("Constructor Test1");
	}
	public Test1(int a)
	{
		//super(10);
		System.out.println("Constructor(int) Test1");
	}
	public static void main(String[] args) 
	{
		Test1 t1=new Test1();
	}

}
