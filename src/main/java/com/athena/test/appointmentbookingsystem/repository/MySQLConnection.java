package com.athena.test.appointmentbookingsystem.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

  public static Connection getConnection() {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      return DriverManager.getConnection("jdbc:mysql://localhost/athena?" + "user=root&password=root");
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException("Error creating MySQL connection");
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Error creating MySQL connection");
    }
  }

}
