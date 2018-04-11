package com.mypack.io.service;

import java.util.List;

import com.mypack.io.Student;
import com.mypack.io.dao.StudentDao;
import com.mypack.io.dao.StudentDaoImpl;

public class StudentServiceImpl implements StudentService {
	@Override
	public int insertStudent(List<Student> studentList) {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.insertStudent(studentList);
	}
}
