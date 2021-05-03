package com.mypack.java8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

public class PredicateFunction {
	private static final Logger log = Logger.getLogger(PredicateFunction.class);

	/***
	 * In mathematical logic, a predicate is a function that receives a value and returns a boolean value.
    	
    	The Predicate functional interface is a specialization of a Function that receives a generified value 
    	and returns a boolean. 
    	
    	A typical use case of the Predicate lambda is to filter a collection of values
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("Imran");
		list.add("Raj");
		list.add("Rahul");
		list.add("Vijay");
		list.add("Pankaj");
		log.info("List without filter : " + list);
		/** Filter with Lamda*/
		List<String> filteredList = list.stream().filter(name-> name.startsWith("R")).collect(Collectors.toList());
		log.info("List after filter : " + filteredList);
		
		/** Filter with Predicate Implementation*/
		
		Predicate<String> myPredicateImpl = new Predicate<String>() {
			@Override
			public boolean test(String value) {
				return value.startsWith("R");
			}
		};
		
		filteredList = list.stream().filter(myPredicateImpl).collect(Collectors.toList());
		
		log.info("List after filter : " + filteredList);
		
		/**Inner class Implementation*/
		filteredList = list.stream().filter(new Predicate<String>() {
			@Override
			public boolean test(String value) {
				return value.startsWith("R");
			}
		}).collect(Collectors.toList());
		
		log.info("List after filter : " + filteredList);
	}

}
