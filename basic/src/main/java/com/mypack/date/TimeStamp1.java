package com.mypack.date;

import java.sql.Timestamp;
import java.util.Date;

public class TimeStamp1 
{
	public static void main( String[] args )throws Exception
    {
         //Date object
	 Date date1= new Date();
         //getTime() returns current time in milliseconds
	 long time = new Date().getTime();
	
         //Passed the milliseconds to constructor of Timestamp class 
	 Timestamp ts = new Timestamp(time);
	 System.out.println("Current Time Stamp: "+ts);
	 Thread.sleep(3010);
	 Date date2= new Date();
	 long time2 = date2.getTime();
	 ts = new Timestamp(time2);
	 System.out.println("Current Time Stamp: "+ts);
	 long tt=time2-time;
	 System.out.println(tt / 1000 % 60);
	 System.out.println(tt / 1 % 60);
	 
    }
}
