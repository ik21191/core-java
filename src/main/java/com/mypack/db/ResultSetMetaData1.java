package com.mypack.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
 
public class ResultSetMetaData1
{
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static void main(String[] args) throws Exception
    {
        Connection connection = null;
        try
        {
            Class.forName(DRIVER);      
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test1");
            ResultSetMetaData metadata = resultSet.getMetaData();
            int columnCount = metadata.getColumnCount();
            //List<String> columns = new ArrayList<>();
            Map<String, String> columnNameType = new HashMap<>();
            
            
            for (int i = 1; i <= columnCount; i++) {
            	columnNameType.put(metadata.getColumnName(i), metadata.getColumnTypeName(i));
            }
            
            Set<Entry<String, String>> entrySet = columnNameType.entrySet();
            
            System.out.println(entrySet);
            
            //Object obj = metadata.getColumnType(i);
            //System.out.println("ColumnName : " + columnName + "\t" + "ColumnType : " + metadata.getColumnTypeName(i));
            //columns.add(columnName);
       
            while (resultSet.next())
            {
            	for (Entry<String, String> entry : entrySet) {
                String column = entry.getKey();
                String type = entry.getValue();
                ///System.out.println(column + "\t\t" + type);
                if(type.equalsIgnoreCase("int")) {
                	System.out.print(resultSet.getInt(column)+"\t");
                } else if(type.equalsIgnoreCase("doubl")){
                	System.out.print(resultSet.getDouble(column)+"\t");
                } else if(type.equalsIgnoreCase("varchar")) {
                	System.out.print(resultSet.getString(column)+"\t");
                } else {
                	System.out.print(resultSet.getString(column)+"\t");
                }
                
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