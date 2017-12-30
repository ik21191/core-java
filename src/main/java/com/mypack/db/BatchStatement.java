package com.mypack.db;

import java.sql.*;

public class BatchStatement {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			con.setAutoCommit(false);
			// Statement stm=con.createStatement();
			String list[]={"Imran","Khan","Pqr","Xyz","TTT"};
			PreparedStatement stm = con.prepareStatement("insert into test1 values(?)");
			//PreparedStatement stm = con.prepareStatement("update test1 set name='aa' where name=?");
			for(String val:list){
				// ResultSet rset=stm.executeQuery(query1);
				stm.setString(1, val);
				stm.addBatch();
			}
			stm.executeBatch();
			//int i=1/1;
			con.rollback();
			con.commit();
			con.close();
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}