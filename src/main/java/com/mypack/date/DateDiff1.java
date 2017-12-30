package com.mypack.date;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDiff1 {
	 
	public static void main(String[] args) {
 
		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String s1=format.format(new Date());
		
//		System.out.println(s);
		Date d1 = null;
		Date d2 = null;
 
		try {
			d1 = format.parse(s1);
			Thread.sleep(5000);
			String s2=format.format(new Date());
			d2 = format.parse(s2);
 
			//in milliseconds
			long diff = d2.getTime() - d1.getTime();
 
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			//long diffHours = diff / (60 * 60 * 1000) % 24;
			//long diffDays = diff / (24 * 60 * 60 * 1000);
 
			//System.out.print(diffDays + " days, ");
			//System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");
 
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}
 
}