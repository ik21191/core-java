package com.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListCapacityCheck1 {

	public static void main(String[] args) {
		
		/**
		 * Initial capacity should be a positive value
		 * //List<String> list = new ArrayList<>(-1);
		 * */
		List<String> list = new ArrayList<>(0);
		
		list.add("Imran Khan");
		
		String str = "imran,khan";
		String[] split = str.split(":");
		System.out.println(split.length);
		System.out.println(list);
	}

}
