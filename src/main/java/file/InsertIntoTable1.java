package file;
import java.io.*;
import java.sql.*;
public class InsertIntoTable1
{
    public static void main(String arr[])
    {
        System.out.println("Program started.");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/imran","root","imran");
            PreparedStatement stm=con.prepareStatement("insert into t1(msisdn) values(?)");
            BufferedReader bdr=new BufferedReader(new FileReader("d:/aa.txt"));
            String line=null;
            while((line=bdr.readLine())!=null)
            {
                stm.setString(1,line.trim());
                //System.out.println(line.length());
                try{stm.executeUpdate();}catch(Exception e){System.out.println(e);}
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Program ended.");
    }
}
