package com.mypack.java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

public class CalculateAge {
	private static final Logger log = Logger.getLogger(CalculateAge.class);
	public static void main(String[] args) {
		LocalDate birthday = LocalDate.of(1984, Month.MAY, 16);
		 
		Period p = Period.between(birthday, LocalDate.now());
		log.info("Year: " + p.getYears() + ", Month: " + p.getMonths() + ", Day: " + p.getDays());
		
		String dateTime = LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		log.info(dateTime);
		YearMonth yearMonth = YearMonth.of(2018, 7);
		log.info(yearMonth.toString());
		
		List<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(2);
		list.add(90);
		list.add(8);
		list.add(1);
		
		Collections.sort(list);
		log.info(list);
		log.info(list.get(0));
		log.info(list.get(list.size()-1));
		
		
		//log.info(Integer.parseInt("01"));
	}
}
