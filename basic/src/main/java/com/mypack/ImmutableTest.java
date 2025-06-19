package com.mypack;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/** Fully immutable class, all fields are final and no setter method */
public class ImmutableTest {

  private static final Logger log = Logger.getLogger(ImmutableTest.class);

  public static void main(String[] args) {

    Age age = new Age();
    age.setDay(16);
    age.setMonth(05);
    age.setYear(1984);

    List<String> courses = new ArrayList<>();
    courses.add("English");
    courses.add("Math");

    ImmutableStudent immutableStudent = new ImmutableStudent(101, "Imran", age, courses);

    log.info("Studen year : " + immutableStudent.getAge().getYear());
    age.setYear(1990); // Change the constructor and see the result
    immutableStudent.getAge().setYear(1990);// change the getter method implementation and see the
                                            // result
    log.info("Studen year : " + immutableStudent.getAge().getYear());

    log.info("Courses : " + immutableStudent.getCourses());
    courses.add("Science"); // change the constructor implementation and see the result
    log.info("Courses after modification into list: " + immutableStudent.getCourses());

  }

}


final class ImmutableStudent {
  private final int id;
  private final String name;
  private final Age age;
  private final List<String> courses;

  /*
   * public ImmutableStudent(int id, String name, Age age, List<String> courses) { this.name = name;
   * this.id = id; this.age = age; this.courses = courses; }
   */

  /*** Constructor for Immutable class, where we are creating clone object of Mutable object: Age */
  public ImmutableStudent(int id, String name, Age age, List<String> courses) {
    this.name = name;
    this.id = id;

    Age cloneAge = new Age();
    cloneAge.setDay(age.getDay());
    cloneAge.setMonth(age.getMonth());
    cloneAge.setYear(age.getYear());
    this.age = cloneAge;

    List<String> cloneCourses = new ArrayList<>();

    for (String course : courses) {
      cloneCourses.add(course);
    }
    this.courses = cloneCourses;
  }


  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  // Returning Mutable Objects From Immutable Class
  public Age getAge() {

    Age cloneAge = new Age();
    cloneAge.setDay(age.getDay());
    cloneAge.setMonth(age.getMonth());
    cloneAge.setYear(age.getYear());

    return cloneAge;
  }


  /*
   * public List<String> getCourses() { return courses; }
   */

  public List<String> getCourses() {

    List<String> cloneCourses = new ArrayList<>();

    for (String course : courses) {
      cloneCourses.add(course);
    }
    return cloneCourses;
  }

  /*
   * public Age getAge() { return this.age; }
   */

}


class Age {
  private int day;
  private int month;
  private int year;

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
