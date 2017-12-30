package com.mypack.db;

import java.sql.*;

import org.apache.log4j.Logger;

public class BatchStatement1 {
	private static final Logger log = Logger.getLogger(BatchStatement1.class);
	public static void main(String[] args) {
		checkPerformanceWithBatch();
		//checkPerformanceSingleHit();
	}
	
	public static void checkPerformanceWithBatch() {
		log.info("Start");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			
			con.setAutoCommit(false);
			
			PreparedStatement stm = con.prepareStatement("insert into test1 values(?)");
			int batchSize = 100;
			for (int i = 1; i <= 10000; i++) {
				stm.setString(1, Integer.toString(i));
				stm.addBatch();
				if (i % batchSize == 0) {
					//log.info(i);
					stm.executeBatch();
				} 
			}
			stm.executeBatch();

			con.commit();
			con.close();
		} catch (Exception e) {
			log.error(e);
			log.error("Exception in this transaction rolling back the changes : " + e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				log.error("Exception while rolling back transaction : " + e);
			}
		}
		log.info("End");
	}
	
	public static void checkPerformanceSingleHit() {
		log.info("Start");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			PreparedStatement stm = null;
			for (int i = 1; i <= 10000; i++) {
				stm = con.prepareStatement("insert into test1 values(?)");
				stm.setString(1, Integer.toString(i));
				stm.executeUpdate();
			}
			con.close();
		} catch (Exception e) {
			log.error(e);
		}
		log.info("End");
	}
}