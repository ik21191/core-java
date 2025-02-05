package com.mypack;

import java.util.ArrayList;
import java.util.List;

public class StaticTest2 
{
final String name;// Without constructor it will show compile time error because the final value must be initialized
final static List<String> list=null;
	public StaticTest2(String name) 
	{
		this.name=name;
	}
	public static void main(String[] args) {
		StaticTest2 t=new StaticTest2("Imrann Khan");
		System.out.println(t.name);
		//list=new ArrayList<String>();//You can not assign object to this final variable
	}

}
