package com.mypack.regex;

import org.apache.log4j.Logger;

public class SplitAndRegex {
	private static Logger log = Logger.getLogger(SplitAndRegex.class);
	
	public static void main(String arr[]) {
		String name = "https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=4028013";
		log.info(name.split("\\?")[1]);
		
		String name2 = "/stamp/stamp.jsp";
		log.info(name2.contains("/stamp/stamp.jsp"));
		
		String stringWithNumber = "1855";
		
		System.out.println("number check: " + stringWithNumber.matches("[0-9]+"));
	}
	
}
