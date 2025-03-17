package com.collection.compareto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyComparatorTest {

	public static void main(String[] args) {
		
		Company c1 = new Company("Imran", "Delhi", 104);
		Company c2 = new Company("Gautam", "Mumbai", 102);
		Company c3 = new Company("Arpit", "Kolkata", 103);
		Company c4 = new Company("Rahul", "Bangalore", 101);
		List<Company> list = new ArrayList<>();
		
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		System.out.println("Before sort:");
		System.out.println(list);

		//Collections.sort(list, new CompanyNameComparator());
		//using java8
		list = list.stream().sorted(new CompanyNameComparator()).collect(Collectors.toList());
		System.out.println("After sort: ");
		System.out.println(list);
	}

}
