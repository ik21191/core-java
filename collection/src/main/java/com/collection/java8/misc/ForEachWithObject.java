package com.collection.java8.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.collection.java8.beans.Course;
import com.collection.java8.beans.Student;

public class ForEachWithObject {
	private static final Logger log = Logger.getLogger(ForEachWithObject.class);
	public static void main(String[] args) {
		list();
		set();
		map();
	}
	
	public static void list() {
		log.info("List started..");
		Course course1 = new Course(1, "PHP");
		Course course2 = new Course(2, "Java");
		Course course3 = new Course(3, "Python");
		Course course4 = new Course(4, "Ruby");
		Course course5 = new Course(5, "MySql");
		
		List<Course> list = new ArrayList<>();
		
		list.add(course1);
		list.add(course2);
		list.add(course3);
		list.add(course4);
		list.add(course5);
		
		//Iterating list element
		log.info("List element before filter: ");
		list.forEach(element->log.info(element));
		
		log.info("List element after filter: ");
		Stream<Course> courseStream = list.stream().filter(element->element.getName().equals("PHP"));
		courseStream.forEach(element->log.info(element));
		
		log.info("List ended.");
	}
	
	public static void set() {
		log.info("Set started.");
		Course course1 = new Course(1, "PHP");
		Course course2 = new Course(2, "Java");
		Course course3 = new Course(3, "Python");
		Course course4 = new Course(4, "Ruby");
		Course course5 = new Course(5, "MySql");
		
		Set<Course> courseSet = new HashSet<>();
		courseSet.add(course1);
		courseSet.add(course2);
		courseSet.add(course3);
		courseSet.add(course4);
		courseSet.add(course5);
		
		//Iterating set element
		courseSet.forEach(element->System.out.println(element));
		log.info("Set end.");
	}
	
	public static void map() {
		log.info("Map started.");
		Student student1 = new Student(201, "Imran Khan");
		Student student2 = new Student(202, "Vinay Kumar");
		Student student3 = new Student(203, "Rahul Kumar");
		Student student4 = new Student(204, "Rakesh");
		Student student5 = new Student(205, "Vikas");
		
		Course course1 = new Course(1, "PHP");
		Course course2 = new Course(2, "Java");
		Course course3 = new Course(3, "Python");
		Course course4 = new Course(4, "Ruby");
		Course course5 = new Course(5, "MySql");
		
		Map<Student, Course> coursesMap = new HashMap<>();
		coursesMap.put(student1, course1);
		coursesMap.put(student2, course2);
		coursesMap.put(student3, course3);
		coursesMap.put(student4, course4);
		coursesMap.put(student5, course5);
		//Iterating map element
		coursesMap.forEach((student, course)->log.info( student + " || " + course));
		log.info("Map end.");
	}

}
