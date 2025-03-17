package com.collection;

import java.util.*;
class X
{
	
}
class Student
{
	int roll;
	String name;
	public Student(int roll,String name)
	{
		this.roll=roll;
		this.name=name;
	}
	public String toString()
	{
		return "Roll :  "+this.roll+"    Name:  "+this.name;
	}
	public boolean equals(Object o)
	{
		Student s=(Student)o;
		return this.roll==s.roll&&this.name.equals(s.name);
	}
}
class Employee
{
	int roll;
	String name;
	public Employee(int roll,String name)
	{
		this.roll=roll;
		this.name=name;
	}
	public String toString()
	{
		return "Roll :  "+this.roll+"    Name:  "+this.name;
	}
	public int hashCode()
	{
		System.out.println("hashCode() in Employee");
		return this.roll+this.name.hashCode();
	}
	public boolean equals(Object o)
	{
		System.out.println("equals(Object ) in Employee");
		Employee s=(Employee)o;
		return this.roll==s.roll&&this.name.equals(s.name);
	}
}
class Cource implements Comparable
{
	int code;
	String name;
	public Cource(int code,String name)
	{
		this.code=code;
		this.name=name;
	}
	public String toString()
	{
		return "Code :  "+this.code+"    Name:  "+this.name;
	}
	@Override
	public int compareTo(Object o) 
	{
		Cource c=(Cource)o;
		return this.code-c.code;
	}
}
class Book
{
	int id;
	String name;
	public Book(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	public int hashCode()
	{
		return this.id+this.name.hashCode();
	}
	public boolean equals(Object o)
	{
		Book b=(Book)o;
		return this.id==b.id&&this.name.equals(b.name);
	}
}
class Author
{
	int id;
	String name;
	public Author(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
}

public class Collection1 
{
	public static void main(String[] args) 
	{
		Collection c1=new ArrayList();
		c1.add("a1");
		c1.add("a2");
		c1.add("a3");
		
		
		Collection c2=new ArrayList();
		c2.add("a1");
		c2.add("a2");
		c2.add("a3");
		c2.add("a4");
		
		System.out.println(c2.containsAll(c1));
		//System.out.println(c2.removeAll(c1));
		//System.out.println(c2.retainAll(c1));
		System.out.println(c2.addAll(c1));
		Iterator itr=c2.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("--------------End Collection methods------------------");
		ArrayList list=new ArrayList();
		list.add(new Student(101,"AA"));
		list.add(new Student(102,"BB"));
		list.add(new Student(102,"CC"));
		System.out.println(list);
		System.out.println(list.contains(new Student(101,"AA")));
		System.out.println("--------------End ArrayList equals method implementation------------------");
		
		Set<Employee> set=new HashSet<Employee>();
		set.add(new Employee(101,"AA"));
		set.add(new Employee(102,"BB"));
		set.add(new Employee(103,"CC"));
		System.out.println("Adding null value "+set.add(null));
		System.out.println("checking contains(object) of HashSet");
		System.out.println(set.contains(new Employee(101,"AA")));//Indeed it calls equals only if hashCode are equal.
		System.out.println("--------------End HashSet equals and hashCode method implementation------------------");
		
		Set<Cource> tset=new TreeSet<Cource>();
		tset.add(new Cource(101,"AA"));
		tset.add(new Cource(103,"AA"));
		tset.add(new Cource(102,"AA"));
		System.out.println(tset);
		System.out.println("--------------End TeeSet compareTo(Object o) method implementation------------------");
		Map m=new HashMap();
		m.put(new Book(101,"X1"),new Author(201,"P1"));
		m.put(new Book(102,"X2"),new Author(202,"P2"));
		m.put(new Book(103,"X3"),new Author(203,"P3"));
		m.put(new Book(104,"X4"),new Author(204,"P4"));
		m.put(new Book(105,"X5"),new Author(205,"P5"));
		System.out.println("Fetching object based on key  :  "+((Author)m.get(new Book(101,"X1"))).name);
		Set eset=m.entrySet();
		Iterator itr1=eset.iterator();
		while(itr1.hasNext())
		{
			Map.Entry entry=(Map.Entry)itr1.next();
			Book book=(Book)entry.getKey();
			Author author=(Author)entry.getValue();
			System.out.println(book.name+"     "+author.name);
		}
		System.out.println("<-------End entrySet() method");
		
		System.out.println("Creating map");
		Map m1=new HashMap();
		System.out.println((m1.put(1,"I")));
		System.out.println((m1.put(2,"j")));
		System.out.println((m1.put(1,"k")));
		System.out.println((String)m1.get(1));
		System.out.println("                                End Map----------------------->");
	}

}
