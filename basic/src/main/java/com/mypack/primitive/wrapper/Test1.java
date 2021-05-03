package com.mypack.primitive.wrapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class Test1 {
	private static final Logger log = Logger.getLogger(Test1.class);
	
	public static void main(String[] args) {
		
		Integer a = new Integer(100);
		Integer b = new Integer(100);
		log.info(a.hashCode() + "    " + b.hashCode());
		log.info("a == b " + (a == b));//results to false, because of Difference object reference
		log.info("a.intValue() == b.intValue() " + (a.intValue() == b.intValue()));//results to true, it is boxing/unboxing, efficient
		log.info("a.equals(b) " + a.equals(b));// true but less efficient
		
		Integer x = 100;// internal working : new Integer(100).intValue
		Integer y = 100;
		
		log.info("x == y " + (x == y)); // results to true
		
		
		int p = new Integer(300);//UnBoxing i.e new Integer(300).intValue();
		int q = new Integer(300);
		log.info("p == q " + (p == q));//results to true
		
		//Checking map
		
		Map<Integer, Integer> map = new HashMap<>();
		
		map.put(100, new Integer(100));
		
		log.info("check map.get(100) == 100 " + (map.get(100) == 100)) ;//true
		log.info("check map.get(100) == 100 " + (map.get(100) == new Integer(100))) ; //false
		
		/********************************/
		log.info(Integer.valueOf("127") == Integer.valueOf("127"));
		log.info(Integer.valueOf("128") == Integer.valueOf("128"));
		log.info(Integer.parseInt("128") == Integer.valueOf("128"));
	}
}
