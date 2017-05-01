package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
 
import java.util.ArrayList;
 
public class ResultSetMetaData1
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
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Emp");
            ResultSetMetaData metadata = resultSet.getMetaData();
            int columnCount = metadata.getColumnCount();
            ArrayList<String> columns = new ArrayList<String>();
            for (int i = 1; i <= columnCount; i++) {
            String columnName = metadata.getColumnName(i);
            columns.add(columnName);
        }
        while (resultSet.next())
        {
            for (String columnName : columns)
            {
                String value = resultSet.getString(columnName);
                System.out.print(value+"\t");
            }
            System.out.println();
        }
    }catch(SQLException e)
    {
        e.printStackTrace();
    } finally {
        connection.close();
    }
    }
}