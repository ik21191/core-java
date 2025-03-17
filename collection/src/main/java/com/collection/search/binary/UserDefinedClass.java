package com.collection.search.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class UserDefinedClass {
	public static void main(String[] args) {
		// Create a list
		List<Domain> list = new ArrayList<>();
		list.add(new Domain(10, "quiz.geeksforgeeks.org"));
		list.add(new Domain(20, "practice.geeksforgeeks.org"));
		list.add(new Domain(30, "code.geeksforgeeks.org"));
		list.add(new Domain(40, "www.geeksforgeeks.org"));

		/*Comparator<Domain> c = new Comparator<Domain>() {
			public int compare(Domain u1, Domain u2) {
				return u1.getId().compareTo(u2.getId());
			}
		};*/
		
		Comparator<Domain> c = (domain1, domain2)-> domain1.getId().compareTo(domain2.getId());
		
		
		// Searching a domain with key value 10. To search
		// we create an object of domain with key 10.
		int index = Collections.binarySearch(list, new Domain(40, null), c);
		System.out.println("Found at index  " + index);
		System.out.println("Getting object on specified index : " + list.get(index));
		// Searching an item with key 5
		index = Collections.binarySearch(list, new Domain(5, null), c);
		System.out.println(index);
	}
}

// A user-defined class to store domains with id and url
class Domain {
	private int id;
	private String url;
	// Constructor
	public Domain(int id, String url) {
		this.id = id;
		this.url = url;
	}
	public Integer getId() {
		return Integer.valueOf(id);
	}
	@Override
	public String toString() {
		return id + "";
	}
}