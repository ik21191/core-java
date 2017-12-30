package com.mypack.db;

import java.sql.*;

import org.apache.log4j.Logger;

public class PreparedStatement1 {
	private static final Logger log = Logger.getLogger(PreparedStatement1.class);
	public static void main(String[] args) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rset = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			
			stm = con.prepareStatement("SELECT * FROM employee WHERE SALARY = ?");
			stm.setDouble(1, 1001);
			rset = stm.executeQuery();
			
			if(rset.next()) {
				String s = "abc?jljlj";
				
				log.info(s.split("\\?")[0]);
				log.info(rset.getString(1));
			}
			
		} catch (Exception e) {
			log.error(e);
		} finally {
			if(con != null) {
				con.close();
			}
			
			if(stm != null) {
				stm.close();
			}
		}
	}
}