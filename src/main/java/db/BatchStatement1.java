package db;

import java.sql.*;

public class BatchStatement1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			con.setAutoCommit(false);
			// Statement stm=con.createStatement();
			PreparedStatement stm = con.prepareStatement("insert into test1 values(?)");
			// PreparedStatement stm =
			// con.prepareStatement("update test1 set name='aa' where name=?");
			int batchSize = 100;
			for (int i = 1; i <= 1051; i++) {
				stm.setString(1, i + "");
				stm.addBatch();
				if (i % batchSize == 0) {
					System.out.println(i);
					stm.executeBatch();
				}
			}
			stm.executeBatch();
			// int i=1/1;
			con.commit();
			con.close();
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}