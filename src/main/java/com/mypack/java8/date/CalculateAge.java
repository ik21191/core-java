package com.mypack.java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

public class CalculateAge {
	private static final Logger log = Logger.getLogger(CalculateAge.class);
	public static void main(String[] args) {
		LocalDate birthday = LocalDate.of(1984, Month.MAY, 16);
		 
		Period p = Period.between(birthday, LocalDate.now());
		log.info("Year: " + p.getYears() + ", Month: " + p.getMonths() + ", Day: " + p.getDays());
		
		String dateTime = LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		log.info(dateTime);
		
		int year = 2015;
		int month = 12;
		int day = 22;
		
		LocalDate date = LocalDate.of(year, month, day);
		log.info("My Customized date is: " + date);
	}
}
