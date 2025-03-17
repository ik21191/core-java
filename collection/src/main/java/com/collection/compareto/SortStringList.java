package com.collection.compareto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

class MyComparator1 implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}
}

class MyComparator2 implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
}

public class SortStringList {
	private static final Logger log = Logger.getLogger(SortStringList.class);
	
	public static void main(String[] args) {
			List<String> list = new ArrayList<>();
			list.add("D");
			list.add("A");
			list.add("Z");
			list.add("A");
			list.add("C");
			
			Collections.sort(list, new MyComparator1());
			log.info("Sorted list using Collections.sort: Descending- " + list);
			list.sort(new MyComparator2());
			log.info("Sorted list using Collections.sort: Ascending- " + list);
	}

}
