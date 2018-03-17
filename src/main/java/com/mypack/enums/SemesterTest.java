package com.mypack.enums;

import java.util.ArrayList;
import java.util.List;

public class SemesterTest {

	public static void main(String[] args) {
		
		List<Semester> list = new ArrayList<Semester>();
		list.add(Semester.SEMESTER1);
		list.add(Semester.SEMESTER2);
		list.add(Semester.SEMESTER3);
		
		for(Semester t : Semester.values()) {
			System.out.println("English: " + t.getEnglish() + ", Math: " + t.getMath() + ", Science: " + t.getScience());
		}
		
		System.out.println(Semester.SEMESTER1.getEnglish());
	}
}
