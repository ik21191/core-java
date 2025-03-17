package com.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapLoadFactor1 {
	
	public static void main(String arr[]) {
		
		//The initial capacity should be greater than 0 and load factor should be greater than zero and less than one
		Map<String, String> hashMap = new HashMap<>(16, 0.75f);
		//Map<String, String> hashMap = new HashMap<>();
		hashMap.put("1", "Imran Khan");
		hashMap.put("2", "Vinay Kumar");
		hashMap.put("2", "Imran Khan");
		hashMap.put("3", "Rahul Kumar");
		System.out.println(hashMap.get("2"));
		
		Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f);
		linkedHashMap.put("1", "Imran Khan");
		linkedHashMap.put(null, "Imran Khan");
		System.out.println("containsKey(null) : " + linkedHashMap.containsKey(null));
		linkedHashMap.put("2", "Vinay Kumar");
		linkedHashMap.put("2", "Imran Khan");
		linkedHashMap.put("3", "Rahul Kumar");
		System.out.println(linkedHashMap.get("2"));
	}

}
