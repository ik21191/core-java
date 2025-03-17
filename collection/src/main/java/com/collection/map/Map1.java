package com.collection.map;
import java.util.*;
import java.util.Map.Entry;

public class Map1 {
    public static void main(String arr[]) {
    	Map<String, String> map = new HashMap<String, String>();
        System.out.println("Adding 1 value " + map.put("key1", "Imran Khan"));
        System.out.println("Adding 2 value " + map.put(null, "ABC"));
        System.out.println("Adding 3 value " + map.put("key1", "Gautam Kumar"));
        Set<Entry<String, String>> entrySet= map.entrySet();
        for(Entry<String, String> entry : entrySet){
        	System.out.println(entry.getKey());
        }
     }
}
