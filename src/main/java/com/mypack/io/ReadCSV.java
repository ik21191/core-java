package com.mypack.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.mypack.io.service.StudentService;
import com.mypack.io.service.StudentServiceImpl;

public class ReadCSV {

	public static void main(String[] args) {
		//Below file is placed in staticFiles folder in this project
		try (BufferedReader br = new BufferedReader(new FileReader("e://student.csv"))){
			
			String line = br.readLine();
			List<Student> studentList = new ArrayList<>();
			while((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				Student student = new Student();
				student.setId(Integer.parseInt(fields[StudentHeader.STUDENT_ID.getIndex()]));
				student.setName(fields[StudentHeader.STUDENT_NAME.getIndex()]);
				student.setMobile(Long.parseLong(fields[StudentHeader.STUDENT_MOBILE.getIndex()]));
				student.setAddress(fields[StudentHeader.STUDENT_ADDRESS.getIndex()]);
				studentList.add(student);
			}
			int count = 0;
			StudentService studentService = new StudentServiceImpl();
			for(int i = 0; i < 3; i++) {
				count = studentService.insertStudent(studentList);	
			}
			
			if(count > 0) {
				System.out.println("Successfully inserted");
			} else {
				System.out.println("Problem while inserting ");
			}
			
		} catch(Exception e) {
			System.out.println(e);
		} 
	}

}
