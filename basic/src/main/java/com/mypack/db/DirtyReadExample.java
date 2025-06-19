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

public class DirtyReadExample {
  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost/test";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "root";

  public static void main(String[] args) throws Exception {

    try (Connection connection1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Connection connection2 = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

      connection1.setAutoCommit(false);
      connection2.setAutoCommit(false);

      // Transaction 1: Update data
      try (Statement statement1 = connection1.createStatement()) {
        statement1.executeUpdate("UPDATE employee SET age = 100 WHERE id = 1");
        System.out.println("Transaction 1: Updated age to 100");
        // Intentionally not committing yet
      } catch (SQLException e) {
        connection1.rollback();
        e.printStackTrace();
      }

      // Transaction 2: Read uncommitted data (dirty read)
      try (Statement statement2 = connection2.createStatement()) {
        // Setting isolation level to READ_UNCOMMITTED to allow dirty reads
        connection2.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        ResultSet resultSet = statement2.executeQuery("SELECT age FROM employee WHERE id = 1");
        if (resultSet.next()) {
          int age = resultSet.getInt("age");
          System.out.println("Transaction 2: Read age as " + age); // Reads 100
        }
        connection2.commit();
      } catch (SQLException e) {
        connection2.rollback();
        e.printStackTrace();
      }

      // Transaction 1: Rollback
      connection1.rollback();
      System.out.println("Transaction 1: Rolled back");

      // Verify the final balance
      try (Statement statement3 = connection2.createStatement()) {
        ResultSet resultSet = statement3.executeQuery("SELECT age FROM employee WHERE id = 1");
        if (resultSet.next()) {
          int age = resultSet.getInt("age");
          System.out.println("Final balance: " + age); // Original balance before update
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
