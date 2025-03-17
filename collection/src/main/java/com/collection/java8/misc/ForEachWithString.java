package com.collection.java8.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

public class ForEachWithString {
	private static final Logger log = Logger.getLogger(ForEachWithString.class);
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("Imran Khan");
		list.add("Vinay Kumar");
		list.add("Raju");
		list.add("Gautam Kumar");
		list.add("Vinay Kumar");
		list.add("Pintu");
		list.add("Raj");
	
		//Iterating list element
		list.forEach(element->log.info(element));
		
		Set<String> courseSet = new HashSet<>();
		courseSet.add("PHP");
		courseSet.add("Java");
		courseSet.add("Python");
		courseSet.add("Ruby");

		//Iterating set element
		courseSet.forEach(element->System.out.println(element));
		
		
		Map<Integer, String> coursesMap = new HashMap<>();
		coursesMap.put(1, "Java");
		coursesMap.put(2, "Apache Spark");
		coursesMap.put(3, "PHP");
		coursesMap.put(4, "Python");
		//Iterating map elemen
		coursesMap.forEach((key, value)->log.info("Key: " + key + ", Value: " + value));
	}

}
