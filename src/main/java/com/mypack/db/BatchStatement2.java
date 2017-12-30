package com.mypack.db;
import java.sql.*;
public class BatchStatement2 {
	public static void main(String[] args) {
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
				con.setAutoCommit(false);
				// Statement stm=con.createStatement();
				String sql="update test1 set name='dd'";
				PreparedStatement stm = con.prepareStatement(sql);
				stm.execute(sql);
				con.commit();
				System.out.println("Updated.");
			} catch (Exception e) {
				System.out.println(e);
		}
	}
}