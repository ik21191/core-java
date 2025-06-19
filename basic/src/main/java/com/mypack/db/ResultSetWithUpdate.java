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

public class ResultSetWithUpdate {
  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost/test";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "root";

  public static void main(String[] args) throws Exception {
    Connection connection = null;
    try {
      Class.forName(DRIVER);
      connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
      Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
      
      ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
      
      if (resultSet.next()) {
        System.out.println("Records present, updating records.........");
        resultSet.previous();
        boolean updated = false;
        while (resultSet.next()) {
          if (resultSet.getString("name").contains("_Updated")) {
            System.out.println("Already updated.");
            break;
          }
          updated = true;
          resultSet.updateString("name", resultSet.getString("name") + "_Updated");
          /**
           * It is mandatory to call below method to reflect the changes in database.
           * */
          resultSet.updateRow();
        }
        if (updated) {
          System.out.println("Records updated.");
        }
      } else {
        System.out.println("No records present.");
      }
          
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      connection.close();
    }
  }
}
