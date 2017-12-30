package com.mypack.db;
import java.sql.*;
public class CallingMysqlFuntion1
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
            CallableStatement cbl= connection.prepareCall("{? = call fun()}");
            cbl.registerOutParameter(1,Types.VARCHAR);
            ResultSet rset=cbl.executeQuery();
            rset.next();
            System.out.println("Getting value.......");
            String value=rset.getString(1);
            System.out.println("Value after calling function:  "+value);
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
create function fun() returns varchar(50) deterministic
begin
declare name varchar(52);
set name='Imran Khan';
return name;
end//
 */