package com.mypack.enums;

public enum Semester {

	SEMESTER1(50, 60, 54), SEMESTER2(40, 40, 78), SEMESTER3(60, 40, 94);
	
	 
	private int english;
	private int math;
	private int science;
	
	private Semester(int english, int math, int science) {
		this.english = english;
		this.math = math;
		this.science = science;
	}


	public int getEnglish() {
		return english;
	}


	public void setEnglish(int english) {
		this.english = english;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public int getScience() {
		return science;
	}


	public void setScience(int science) {
		this.science = science;
	}
	
	
	 
}
