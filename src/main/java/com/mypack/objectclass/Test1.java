package com.mypack.objectclass;
class A
{
	int id;
	String name;
	public A(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	@Override
	public boolean equals(Object obj) 
	{
		System.out.println("equals(Object)");
		A a=(A)obj;
		boolean x=this.name.equalsIgnoreCase(a.name)&&this.id==a.id;
		System.out.println("Value of x variable is :  "+x);
		return x;
	}
	@Override
	public int hashCode() 
	{
		System.out.println("hashCode()");
		return this.name.hashCode()+this.id;
	}
}
public class Test1 
{
	public static void main(String[] args) 
	{
		A a=new A(101,"AA");
		A b=new A(101,"AA");
		A c=a;
		System.out.println(a.equals(b));
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println("Checking hashCode  "+(a.hashCode()==b.hashCode()));
		String ss="Imran";
		String sss="Imran";
		System.out.println(ss.hashCode()+"    "+sss.hashCode());
	}
}