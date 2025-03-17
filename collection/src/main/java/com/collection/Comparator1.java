package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
class Student1
{
	int id;
	double salary;
	String name;
	public Student1(int id, double salary, String name) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
	}
	public Student1() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() 
	{
		return id+"    "+name;
	}
}
class Student1SalaryComparator implements Comparator<Student1>
{
	@Override
	public int compare(Student1 s1, Student1 s2) 
	{
		return (int)s2.salary-(int)s1.salary;
		//return s1.name.compareTo(s2.name);
	}
}

class Org
{
	int id;
	String orgName;
	public Org(int id,String orgName)
	{
		this.id=id;
		this.orgName=orgName;
	}
}
class SortWithId implements Comparator<Org>
{
	public int compare(Org org1, Org org2) 
	{
		return org1.id-org2.id;
	}
}
class SortWithName implements Comparator<Org>
{
	public int compare(Org org1, Org org2) 
	{
		return org1.orgName.compareTo(org2.orgName);
	}
}
public class Comparator1 
{
	public static void main(String[] args) 
	{
		TreeSet<Org> tset=new TreeSet<>(new SortWithId());
		tset.add(new Org(103,"D"));
		tset.add(new Org(101,"X"));
		tset.add(new Org(104,"A"));
		tset.add(new Org(102,"C"));
		Iterator<Org> itr = tset.iterator();
		while(itr.hasNext())
		{
			Org org=(Org)itr.next();
			System.out.println(org.id+"     "+org.orgName);
		}
		System.out.println("sorting list...............Collections.sort(List, Comparator)");
		List<Student1> list=new ArrayList<>();
		list.add(new Student1(103,5001.55,"AA"));
		list.add(new Student1(104,500.55,"AC"));
		list.add(new Student1(102,5005.55,"AB"));
		list.add(new Student1(101,5007.55,"AD"));
		Collections.sort(list, new Student1SalaryComparator());
		System.out.println(list);
		
		boolean a = false;
		boolean b = true;
		if(a&&!b)
			System.out.println("if block");
		else
			System.out.println("else block");
		int i = 0;
		while(true)
		{
			list.add(new Student1(103, 5001.55, "AA"));
			System.out.println(i++);
			if(i == 1)
				break;
		}
	}

}
