package com.collection.set;

import java.util.Set;
import java.util.TreeSet;


public class TreeSet1 {

	public static void main(String[] args) {
	
		//Set<Mobile> set = new TreeSet<Mobile>();
		// Below will given more priority than above creation of Set object for sorting the elements
		Set<Mobile> set = new TreeSet<Mobile>(new MobileNameComparator());
		Mobile m1 = new Mobile("Nokia", 104);
		Mobile m2 = new Mobile("Samsung", 101);
		Mobile m3 = new Mobile("LG", 102);
		Mobile m4 = new Mobile("Micromax", 103);
		set.add(m1);
		set.add(m2);
		set.add(m3);
		set.add(m4);
		Mobile m5 = new Mobile("Nokia", 104);
		System.out.println("Searching mobile : " + set.contains(m5));
		System.out.println(set);
	}

}
