package com.mypack.db;

import java.sql.*;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

class MyFilterPredicate implements Predicate {

  @Override
  public boolean evaluate(Object value, int column) throws SQLException {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean evaluate(Object value, String columnName) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public boolean evaluate(RowSet rs) {
    System.out.println("SearchFilter.evaluate called ");
    try {
      if (!rs.isAfterLast()) {
        String name = rs.getString("name");
        System.out.println("Searching for test data");
       return name.contains("test");
      } else
        return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}


public class FilteredRowSetExample {

  private static final String[] NAMES =
      {"Bill Gates", "test employee", "test", "Imran Khan"};

  public static void main(String[] args) throws Exception {
    Connection c = DriverManager.getConnection("jdbc:h2:mem:db1", "test", "test");
    // Just only prepare data for test
    prepareData(c);
    RowSetFactory rowSetFactory = RowSetProvider.newFactory();
    FilteredRowSet filteredRowSet = rowSetFactory.createFilteredRowSet();
    filteredRowSet.setCommand("select * from test");
    filteredRowSet.execute(c);
    filteredRowSet.setFilter(new MyFilterPredicate());
    dumpRS(filteredRowSet);

  }

  public static void dumpRS(ResultSet rs) throws SQLException {
    ResultSetMetaData rsmd = rs.getMetaData();
    int cc = rsmd.getColumnCount();
    while (rs.next()) {
      for (int i = 1; i <= cc; i++) {
        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getObject(i) + " ");
      }
      System.out.println("");
    }
  }

  private static void prepareData(Connection c) throws SQLException {
    c.createStatement().execute("create table test (name varchar(256))");
    PreparedStatement prepareStatement = c.prepareStatement("insert into test (name) values (?)");
    for (String name : NAMES) {
      prepareStatement.setString(1, name);
      prepareStatement.execute();
    }
  }

}
