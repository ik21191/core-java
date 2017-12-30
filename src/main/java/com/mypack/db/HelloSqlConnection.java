package com.mypack.db;
import java.sql.*;
import java.sql.DriverManager;
public class HelloSqlConnection 
{
	public static void main(String[] args) 
	{
		try
		{
			String name="\'Imran \'or \'1\'=\'1\'";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/test1","root","root");
			String query1="select name from test1 where name="+name;
			System.out.println(query1);
			//Statement stm=con.createStatement();
			PreparedStatement stm=con.prepareStatement(query1);
			//stm.setString(1, name);
			//ResultSet rset=stm.executeQuery(query1);
			ResultSet rset=stm.executeQuery();
			while(rset.next())
			{
				System.out.println(rset.getString(1));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
