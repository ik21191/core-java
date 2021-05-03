package com.mypack.exceptions;
public class ExceptionHierarchy1 
{
	public void display()throws Exception{
		
	}
	public static void main(String[] args) 
	{
		ExceptionHierarchy1 a=new ExceptionHierarchy1();
		//a.display();
		try
		{
			a.display();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
