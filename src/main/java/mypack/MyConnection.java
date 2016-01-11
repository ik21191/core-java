package mypack;

import java.sql.*;
public class MyConnection implements Constants_JDBC
{
    public static Connection con=null;
    public static Connection getConnection()
    {
        try
        {
            if(con==null)
            {
                System.out.println("if block of MyConnection");
                Class.forName(driver);
                con=DriverManager.getConnection(url,user,password);
                System.out.println(con);
                return con;
            }
            else if(con.isClosed())
            {
                System.out.println("else if block of getConnection() of MyConnection.");
                con=DriverManager.getConnection(url,user,password);
                System.out.println(con);
                return con;
            }
            else
            {
                System.out.println("else block of MyConnection");
                return con;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
}
