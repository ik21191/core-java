package db;
import java.sql.*;
public class CallingMysqlProcedure2
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
            CallableStatement cbl= connection.prepareCall("call p5(?)");
            cbl.registerOutParameter(1,Types.VARCHAR);
            cbl.executeQuery();
            System.out.println("Getting value.......");
            String value=cbl.getString(1);
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
create procedure p5(OUT a varchar(25))
begin
set a='Imran Khan';
end//

 */