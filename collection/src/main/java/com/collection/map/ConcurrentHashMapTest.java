package com.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	
	public static void main(String arr[]) {
		/**ConcurrentHashMap doesn't allow null as key or value or both*/
		Map<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
		//concurrentHashMap.put("1", null);
		//concurrentHashMap.put(null, "Imran");
		//concurrentHashMap.put(null, null);
		System.out.println("containsKey(null) : " + concurrentHashMap.containsKey(null));
		concurrentHashMap.put("1", "Imran Khan");
		concurrentHashMap.put("2", "Vinay Kumar");
		concurrentHashMap.put("3", "Rahul Kumar");
		System.out.println(concurrentHashMap.get("2"));
	}

}
