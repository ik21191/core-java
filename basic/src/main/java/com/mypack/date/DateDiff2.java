package com.mypack.date;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDiff2 {
	 
	public static void main(String[] args) {
 
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-yyyy HH:mm:ss");
		
		
//		
		
		 
		try {
			Date d1 = format.parse(format.format(new Date()));
			Thread.sleep(5000);
			Date d2 = format.parse(format.format(new Date()));
			
 System.out.println(format.format(new Date()));
			//in milliseconds
			long diff = d2.getTime() - d1.getTime();
 
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			System.out.println(diffMinutes + " minutes, ");
			System.out.println(diffSeconds + " seconds.");
			long ddd=format.parse(format.format(new Date())).getTime()-format.parse(format.format(new Date())).getTime();
			System.out.println("kkkkkkkkkk "+ddd);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}
 
}