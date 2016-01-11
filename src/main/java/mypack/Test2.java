package mypack;

import java.sql.*;

public class Test2
{
    public static void main(String arr[])throws Exception
    {
        Connection con=MyConnection.getConnection();
        System.out.println("Connection created.");
        System.out.println("Connection object is   "+con);
        System.out.println("Displaying record");
        Statement stmt=con.createStatement();
        ResultSet set=stmt.executeQuery("select right(msisdn,10) from subscriber_master limit 10");
        while(set.next())
        {
            System.out.println("no is  "+set.getString(1));
        }
        System.out.println("Closing connection...............");
//        con.close();
//        System.out.println("Connection closed.");
//        con=MyConnection.getConnection();
//        System.out.println("\nRunning same code again\n");
//        System.out.println("Connection created.");
//        System.out.println("Displaying record");
//        stmt=con.createStatement();
//        set=stmt.executeQuery("select * from temp1");
//        while(set.next())
//        {
//            System.out.println("no is  "+set.getString(1));
//        }
    }
}
