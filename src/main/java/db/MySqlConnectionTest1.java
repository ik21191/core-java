package db;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
public class MySqlConnectionTest1 
{
	public static void main(String[] args) 
	{
		try
		{
			List<Integer> list=new ArrayList<Integer>();
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(4);
			List<String> list2=new ArrayList<String>();
			list2.add("XYZ");
			list2.add("ABC");
			System.out.println(list);
			String s=list2.toString().replace("[", "").replace("]", "")
            .replace(", ", ",");
			s="'"+StringUtils.join(list2, "','")+"'";
			System.out.println(s);
	//		list.
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/test1","root","root");
			String query1="select count(*) from test1 where name in ("+s+")";
			System.out.println(query1);
			PreparedStatement stm=con.prepareStatement(query1);
			//stm.setString(1, s);
			ResultSet rset=stm.executeQuery(query1);
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
