package com.mypack;
final class X1
{
	public int a=100;
}
public class BoxingUnboxing1 
{
	X1 x=new X1();
	public void display(Integer i)
	{
		System.out.println(i.toString());
		System.out.println("Valud of x.a is "+x.a);
	}
	public static void main(String[] args) 
	{
		BoxingUnboxing1 o=new BoxingUnboxing1();
		o.display(100);
	}
}
