package com.collection;

import java.util.*;

public class List1 {
	public static void main(String arr[]) {
		try {
			List<String> list = new ArrayList<>(10);
			System.out.println("Adding null value...............");
			list.add("Imran");
			list.add("Vinay");
			list.add(1, "Suhail");
			list.add(1, "Shyam");
			list.add(6, "Teena");// Will throw an exception at this line
			System.out.println("Added.");
			int i = 1;
			System.out.println("Fetching object at " + i + "  " + list.get(i));
			
			ListIterator<String> listIterator = list.listIterator();
			
			while(listIterator.hasNext()) {
				System.out.println(listIterator.next());
				listIterator.add("test");
			}
			
			//Printing with advanced for loop
			System.out.println(list);
			for (String s : list) {
				System.out.println(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
