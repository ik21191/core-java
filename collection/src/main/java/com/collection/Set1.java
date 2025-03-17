package com.collection;
import java.util.*;
public class Set1
{
    public static void main(String arr[])throws Exception
    {
    	Set<String> hashSet = new HashSet<String>();
    	Set<String> hashSet2 = new HashSet<String>();
    	
    	 /*
         * You can add second value onwards as null value to the HashSet but not in TreeSet
         */

        hashSet.add("AA");
        System.out.println("Adding null value: " + hashSet.add(null));
        System.out.println(hashSet.size());
        hashSet2 = hashSet;
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("AA");
        //treeSet.add(null);
        System.out.println(treeSet.size());
        
        hashSet = Collections.unmodifiableSet(hashSet);
        System.out.println("Adding value in hashSet2 " + hashSet2.add("Imran"));
        hashSet.add("Imran");//will throw java.lang.UnsupportedOperationException
        
        
    }
}
