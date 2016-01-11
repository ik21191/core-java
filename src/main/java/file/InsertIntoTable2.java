package file;

import java.io.*;
import java.sql.*;

public class InsertIntoTable2
{
    public static void main(String arr[])
    {
        System.out.println("Program started.");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection
            ("jdbc:mysql://192.168.1.211:3306/Idea_DND","root","1234");
            PreparedStatement stm=con.prepareStatement("insert into temp1(msisdn) values(?)");
            stm.setString(1,"8802529677");
//            PreparedStatement stm=con.prepareStatement("insert into n1(msisdn) values(?)");
//            stm.setNString(1,"8802529677");
            try{stm.executeUpdate();}catch(Exception e){System.out.println(e);}
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Program ended.");
    }
}
