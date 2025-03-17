package com.collection.msc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public class Collections1 {
public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		//list  = (List<String>) Collections.synchronizedCollection(list);//throw java.lang.ClassCastException
		Collection<String> collection  = Collections.synchronizedCollection(list);//Will not throw java.lang.ClassCastException
		System.out.println(collection);
		list  = Collections.synchronizedList(list);
		Collections.synchronizedCollection(set);
		System.out.println(list.get(0));
		
		//Below iteration will result in non-deterministic behavior
		  Iterator<String> ite1 = list.iterator();
		  while (ite1.hasNext()) {
			  String s = ite1.next();
			  System.out.print(s + "\t");
		  }
		  //Below code is the right way to iterate synchronized collection
		  System.out.println();
		  synchronized(list) { 
			  Iterator<String> ite2 = list.iterator();
			  while (ite2.hasNext()) {
				  String s = ite2.next();
				  System.out.print(s + "\t");
			  }
		  }
	}

}
