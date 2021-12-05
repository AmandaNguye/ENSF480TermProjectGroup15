package src.Database;

import java.io.*;
import java.sql.*;
import java.util.*;
import src.Entities.*;

public class RentalDatabaseObject {

  private Connection myConn;

  public RentalDatabaseObject() throws Exception {
    // get db properties
    Properties acct = new Properties();
    acct.load(new FileInputStream("src/Database/account.properties"));

    String user = acct.getProperty("user");
    String password = acct.getProperty("password");
    String dburl = acct.getProperty("dburl");

    // connect to database
    myConn = DriverManager.getConnection(dburl, user, password);

    System.out.println("DB connection successful to: " + dburl);
  }

  public List<User> getAllUsers() throws Exception {
    List<User> list = new ArrayList<>();

    Statement query = null;
    ResultSet results = null;

    try {
      query = myConn.createStatement();
      results = query.executeQuery("SELECT * FROM users");

      while (results.next()) {
        User tempUser = convertRowToUser(results);
        list.add(tempUser);
      }
      return list;
    } finally {
      close(query, results);
    }
  }

  public List<User> searchUsername(String username) throws Exception {
    List<User> list = new ArrayList<>();

    PreparedStatement query = null;
    ResultSet results = null;

    try {
      query = myConn.prepareStatement("SELECT * FROM users WHERE username=?");
      query.setString(1, username);

      results = query.executeQuery();
      while (results.next()) {
        User tempUser = convertRowToUser(results);
        list.add(tempUser);
      }
      return list;
    } finally {
      close(query, results);
    }
  }

  private User convertRowToUser(ResultSet set) throws SQLException {
    String username = set.getString("username");
    String password = set.getString("password");
    String accountType = set.getString("accounttype");

    User tempUser = new User(username, password, accountType);

    return tempUser;
  }

  private static void close(
    Connection myConn,
    Statement myStmt,
    ResultSet myRs
  )
    throws SQLException {
    if (myRs != null) {
      myRs.close();
    }

    if (myStmt != null) {}

    if (myConn != null) {
      myConn.close();
    }
  }

  private void close(Statement myStmt, ResultSet myRs) throws SQLException {
    close(null, myStmt, myRs);
  }
  /*
    public static void main(String[] args) throws Exception {
    RentalDatabaseObject dao = new RentalDatabaseObject();

    System.out.println(dao.getAllUsers());
    System.out.println(dao.searchUsername("moussavifan"));
  }
  */
}
