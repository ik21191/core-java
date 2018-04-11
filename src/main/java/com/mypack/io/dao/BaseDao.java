package com.mypack.io.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class BaseDao {
	private static Connection con = null;
	
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/test";
	private static String USER = "root";
	private static String PASSWORD = "root";
	
	protected Connection getConnection() throws Exception {
		try {
			Class.forName(DRIVER);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		return con;
	}
}	
