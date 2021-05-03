package com.mypack.io.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import com.mypack.io.Student;
import com.mypack.io.dao.StudentDao;

public class StudentServiceImplTest {
	@Mock
	StudentDao studentDao;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void insertStudent() {
		//Given
		List<Student> list = mock(List.class);
		
		//when
		when(studentDao.insertStudent(list)).thenReturn(3);
		
		//then
		StudentService studentService = new StudentServiceImpl() {
			protected StudentDao getStudentDao() {
				return studentDao;
			}
		};
		
		int resultCount = studentService.insertStudent(list);
		assertEquals(3, resultCount);
	}
	
}
