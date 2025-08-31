package com.mypack;

import java.util.ArrayList;
import java.util.List;

enum Semester {

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


public class SemesterTest {

  public static void main(String[] args) {

    List<Semester> list = new ArrayList<Semester>();
    list.add(Semester.SEMESTER1);
    list.add(Semester.SEMESTER2);
    list.add(Semester.SEMESTER3);

    for (Semester t : Semester.values()) {
      System.out.println(
          "English: " + t.getEnglish() + ", Math: " + t.getMath() + ", Science: " + t.getScience());
    }

    System.out.println("\nDisplay via method: ");
    method(Semester.SEMESTER1);
  }

  private static void method(Semester semester) {
    System.out.println("English: " + semester.getEnglish() + ", Math: " + semester.getMath()
        + ", Science: " + semester.getScience());
  }
}
