package com.mypack.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleTest {

	public static void main(String args[]) {
		try {/*compatibility oracle 18c with ojdbc6*/
			System.out.println("Start");
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE", "SYSTEM", "123456");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			ResultSet rs = stmt.executeQuery("select * from test");
			while (rs.next()) {
				//long roll = rs.getLong(2); // To check whether the roll is null we need to call getString method.
				String roll = rs.getString(2);
				System.out.println("Name: " + rs.getString(1));
				System.out.println("Roll: " + roll);
			}

			// step5 close the connection object
			con.close();
			System.out.println("End");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}