package com.mypack.io.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mypack.io.Student;

public class StudentDaoImpl extends BaseDao implements StudentDao{
	@Override
	public int insertStudent(List<Student> studentList) {
		Connection con = null;
		PreparedStatement stmt = null;
		int totalRecordsInserted = 0;
		try {
			con =  getConnection();
			con.setAutoCommit(false);
			stmt = con.prepareStatement("INSERT INTO STUDENT VALUES(?, ?, ?, ?)");
			int batchSize = 1;
			int count = 0;
			
			for(Student student : studentList) {
				++count;
				stmt.setInt(1, student.getId());
				stmt.setString(2, student.getName());
				stmt.setLong(3, student.getMobile());
				stmt.setString(4, student.getAddress());
				stmt.addBatch();
				if(batchSize % count == 0) {
					totalRecordsInserted = totalRecordsInserted + stmt.executeBatch().length;
					batchSize = 0;
				}
			}
			stmt.executeBatch();
			con.commit();
			
		} catch(Exception e) {
			System.out.println("rolling back the changes: " + e);
			totalRecordsInserted = 0;
			if(con != null) {
				try {
					con.rollback();
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return totalRecordsInserted;
	}
}
