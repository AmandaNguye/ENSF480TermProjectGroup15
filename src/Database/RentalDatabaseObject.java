package RentalManagement.Database;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class RentalDatabaseObject {

  private Connection myConn;

  public RentalDatabaseObject() throws Exception {
    // get db properties
    Properties props = new Properties();
    props.load(new FileInputStream("account.properties"));

    String user = props.getProperty("user");
    String password = props.getProperty("password");
    String dburl = props.getProperty("dburl");

    // connect to database
    myConn = DriverManager.getConnection(dburl, user, password);

    System.out.println("DB connection successful to: " + dburl);
  }
}
