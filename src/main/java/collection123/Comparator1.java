package collection123;

import java.util.*;
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
class Student1SalaryComparator implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) 
	{
		Student1 s1=(Student1)o1;
		Student1 s2=(Student1)o2;
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
class SortWithId implements Comparator
{
	public int compare(Object o1, Object o2) 
	{
		Org obj1=(Org)o1;
		Org obj2=(Org)o2;
		return obj1.id-obj2.id;
	}
}
class SortWithName implements Comparator
{
	public int compare(Object o1, Object o2) 
	{
		Org obj1=(Org)o1;
		Org obj2=(Org)o2;
		return obj1.orgName.compareTo(obj2.orgName);
	}
}
public class Comparator1 
{
	public static void main(String[] args) 
	{
		TreeSet tset=new TreeSet(new SortWithId());
		tset.add(new Org(103,"D"));
		tset.add(new Org(101,"X"));
		tset.add(new Org(104,"A"));
		tset.add(new Org(102,"C"));
		Iterator itr=tset.iterator();
		while(itr.hasNext())
		{
			Org org=(Org)itr.next();
			System.out.println(org.id+"     "+org.orgName);
		}
		System.out.println("sorting list...............Collections.sort(List,Comparator)");
		List list=new ArrayList();
		list.add(new Student1(103,5001.55,"AA"));
		list.add(new Student1(104,500.55,"AC"));
		list.add(new Student1(102,5005.55,"AB"));
		list.add(new Student1(101,5007.55,"AD"));
		Collections.sort(list,new Student1SalaryComparator());
		System.out.println(list);
		
		boolean a=false;
		boolean b=true;
		if(a&&!b)
			System.out.println("if block");
		else
			System.out.println("else block");
		int i=0;
		while(true)
		{
			list.add(new Student1(103,5001.55,"AA"));
			System.out.println(i++);
			if(i==1)
				break;
		}
	}

}
