package database;
import java.sql.*;
public class CallingMysqlProcedure1
{
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.1.211/imran2";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    public static void main(String[] args) throws Exception
    {
        Connection connection = null;
        try
        {
            Class.forName(DRIVER);      
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            CallableStatement cbl= connection.prepareCall("call p3()");
            ResultSet rset=cbl.executeQuery();
            rset.next();
            System.out.println("Getting value.......");
            int value=rset.getInt("Value");
            //int value=rset.getInt(1);
            System.out.println("Value after calling procedure:  "+value);
            System.out.println();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
/*
 delimiter //
create procedure p3()
begin
declare a int default 100;
select a as value;
end//

 
 */