package com.mypack.date;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZoneTest1 {
	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
		
		System.out.println("Minute: "+Calendar.MINUTE);
		System.out.println("Default time zone: "+TimeZone.getDefault());
		//calendar.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

		calendar.set(Calendar.HOUR_OF_DAY, 12);

		System.out.println("UTC: " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("UTC hour: " + calendar.get(Calendar.HOUR));
		System.out.println("UTC: " + calendar.getTimeInMillis());

		calendar.setTimeZone(TimeZone.getTimeZone("Europe/Copenhagen"));
		System.out.println("CPH: " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("CPH: " + calendar.getTimeInMillis());

		calendar.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		System.out.println("NYC: " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("NYC: " + calendar.getTimeInMillis());
		
		calendar.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		System.out.println("IND: " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("IND: " + calendar.getTimeInMillis());
		
		String[] availableIDs = TimeZone.getAvailableIDs();

		for(String id : availableIDs) {
		    //System.out.println("id = " + id);
		}
		
	}

}
