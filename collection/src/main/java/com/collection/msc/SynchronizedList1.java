package com.collection.msc;
import java.util.*;

public class SynchronizedList1 
{
	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<>();
		list.add(null);
		list.add("Imran Khan");
		synchronized(list){
		Iterator<String> i = list.iterator(); // Must be in synchronized block
		      while (i.hasNext()){
		          System.out.println(i.next());}
		}
		System.out.println(list.contains(null));
		List<Student> sList = new ArrayList<>();
		sList.add(new Student("Imran Khan"));
		sList.add(new Student("Vinay Kumar"));
		for(Object o : sList)
		{
			Student s = (Student)o;
			sList.remove(1);
			System.out.println(s);
		}
		System.out.println(sList);
	}

}
