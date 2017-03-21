package compareTo;

import java.util.*;

public class SortingListOfCource 
{
	public static List<Cource> mySort(List<Cource> list)
	{
		CourceParent p = new CourceParent();
		p.setSortBy("desc_name");
		Collections.sort(list,p);
		return list;
	}
	public static void main(String[] args) {
		List<Cource> myList = new ArrayList<Cource>();
		List<Cource> toSortList = new ArrayList<Cource>();
		myList.add(new Cource(3, "Core Java", 500));
		myList.add(new Cource(5, "Accounts", 400));
		myList.add(new Cource(1, "Linux", 800));
		myList.add(new Cource(4, "J2EE", 300));
		myList.add(new Cource(2, "English", 900));
		System.out.println("Before..........");
		System.out.println(myList + "\nAfter...........");
		for(Cource c : myList)
		{
			Cource cource = c;
			toSortList.add(cource);
		}
		System.out.println(mySort(toSortList));
	}
}
