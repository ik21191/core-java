package com.mypack.io.dao;

import java.util.List;

import com.mypack.io.Student;

public interface StudentDao {
	int insertStudent(List<Student> studentList);
}
