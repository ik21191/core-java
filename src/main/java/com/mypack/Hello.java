package com.mypack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "/rest/document/7932890?logAccess=true";
		if(str.equals("/rest/document/7932890?logAccess=true")) {
			System.out.println("both are equals" + "\t" + str.compareTo("/rest/document/7932890?logAccess=true"));
		}
		
		Double d = 201.0;
		long l = Math.round(d);
		int k =201;
		System.out.println(l == k);
		
		Set<Long> set = new HashSet<>();
		set.add(100L);
		set.add(200L);
		set.add(300L);
		Integer longVal = 100;
		System.out.println("Check value : " + set.contains(longVal.longValue()));
		
		Object obj1 = 20.0;
		Object obj2 = 20;
		
		//Object obj = dbl;
		if(obj1 instanceof Double) {
			System.out.println("yes " + ((Double)obj1).intValue());
		}
		
		if(obj2 instanceof Integer) {
			System.out.println((Integer)obj2);
		}
		
		
		if(obj2 instanceof Long) {
			System.out.println((Long)obj2);
		}
		
		
		String url = "ldjldjljljlkjenterprise.astm.orgdjljlkjdljdl";
		System.out.println("check url " + url.contains("enterprise.astm.org"));
		
	}
	
	
	
		
}
