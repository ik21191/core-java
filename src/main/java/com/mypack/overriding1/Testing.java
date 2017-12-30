package com.mypack.overriding1;
abstract class AA
{
	public AA()
	{
		System.out.println("AA() of AA");
	}
	public void display()
	{
		System.out.println("display of A");
	}
	public abstract void doit();
}
public class Testing extends AA
{
	public void doit()
	{
		System.out.println("doit of implementation in Testing");
	}
	public void display()
	{
		System.out.println("display of Testing");
	}
	public void print()
	{
		System.out.println("print of Testing");
	}
	public static void main(String[] args) 
	{
		AA t=new Testing();
		t.display();
	}
}
