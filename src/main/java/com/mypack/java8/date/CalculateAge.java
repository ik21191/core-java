package com.mypack.java8.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import org.apache.log4j.Logger;

public class CalculateAge {
	private static final Logger log = Logger.getLogger(CalculateAge.class);
	public static void main(String[] args) {
		LocalDate birthday = LocalDate.of(1984, Month.MAY, 16);
		 
		Period p = Period.between(birthday, LocalDate.now());
		log.info("Year: " + p.getYears() + ", Month: " + p.getMonths() + ", Day: " + p.getDays());
	}

}
