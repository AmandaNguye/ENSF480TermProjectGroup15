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

  public void enterUser(User newUser) throws Exception {
    PreparedStatement query = null;
    ResultSet results = null;

    try {
      query =
        myConn.prepareStatement(
          "INSERT INTO users (username, password, accounttype) VALUES (?, ?, ?)"
        );
      query.setString(1, newUser.getUsername());
      query.setString(2, newUser.getPassword());
      query.setString(3, newUser.getAccountType());
      System.out.println(query.toString());
      int rowcount = query.executeUpdate();
      System.out.println("Success - " + rowcount + " rows affected.");
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

  public List<Property> getAllProperties() throws Exception {
    List<Property> list = new ArrayList<>();

    Statement query = null;
    ResultSet results = null;

    try {
      query = myConn.createStatement();
      results = query.executeQuery("SELECT * FROM properties");

      while (results.next()) {
        Property tempProperty = convertRowToProperty(results);
        list.add(tempProperty);
      }
      return list;
    } finally {
      close(query, results);
    }
  }

  public List<Property> searchPropertyName(String name) throws Exception {
    List<Property> list = new ArrayList<>();

    PreparedStatement query = null;
    ResultSet results = null;

    try {
      query = myConn.prepareStatement("SELECT * FROM properties WHERE name=?");
      query.setString(1, name);

      results = query.executeQuery();
      while (results.next()) {
        Property tempProperty = convertRowToProperty(results);
        list.add(tempProperty);
      }
      return list;
    } finally {
      close(query, results);
    }
  }

  public List<Property> searchProperties(
    String type,
    int bedrooms,
    int bathrooms,
    String quadrant,
    Boolean furnished
  )
    throws Exception {
    updatePropertyStatus();
    List<Property> list = new ArrayList<>();

    PreparedStatement query = null;
    ResultSet results = null;
    int furnishedInt = 0;
    if (furnished) furnishedInt = 1;
    try {
      String tempquery = "SELECT * FROM properties WHERE";
      if (!type.equals("any")) {
        tempquery += " type = '" + type + "'";
      }
      if (!tempquery.equals("SELECT * FROM properties WHERE")) {
        tempquery += " AND";
      }
      tempquery += " bedrooms >= " + bedrooms;
      tempquery += " AND bathrooms >= " + bathrooms;
      if (!quadrant.equals("Any")) {
        tempquery += " AND quadrant = '" + quadrant + "'";
      }
      tempquery += " AND furnished >= " + furnishedInt;
      tempquery += " AND status = 'active'";
      System.out.println(tempquery);
      query = myConn.prepareStatement(tempquery);

      results = query.executeQuery();
      while (results.next()) {
        Property tempProperty = convertRowToProperty(results);
        list.add(tempProperty);
      }
      return list;
    } finally {
      close(query, results);
    }
  }

  private void updatePropertyStatus() throws SQLException {
    PreparedStatement query = null;
    ResultSet results = null;

    try {
      query =
        myConn.prepareStatement(
          "UPDATE properties SET status = 'suspended' WHERE status = 'active' AND expirydate <= ?"
        );
      query.setString(1, java.time.LocalDate.now().toString());
      System.out.println(query.toString());
      int rowcount = query.executeUpdate();
      System.out.println("Success - " + rowcount + " rows affected.");
    } finally {
      close(query, results);
    }
  }

  private Property convertRowToProperty(ResultSet set) throws SQLException {
    int id = set.getInt("id");
    String name = set.getString("name");
    String owner = set.getString("owner");
    String type = set.getString("type");
    int bedrooms = set.getInt("bedrooms");
    int bathrooms = set.getInt("bathrooms");
    int furnished = set.getInt("furnished");
    String quadrant = set.getString("quadrant");
    String status = set.getString("status");
    String expirydate = set.getString("expirydate");

    boolean furnishedBool = false;
    if (Integer.valueOf(furnished) == 1) {
      furnishedBool = true;
    }

    Property tempProperty = new Property(
      id,
      name,
      owner,
      type,
      bedrooms,
      bathrooms,
      furnishedBool,
      quadrant,
      status,
      expirydate
    );

    return tempProperty;
  }

  public void enterProperty(Property newProperty) throws Exception {
    PreparedStatement query = null;
    ResultSet results = null;

    try {
      query =
        myConn.prepareStatement(
          "INSERT INTO properties (name, owner, type, bedrooms, bathrooms, furnished, quadrant, status, expirydate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );
      query.setString(1, newProperty.getName());
      query.setString(2, newProperty.getOwner());
      query.setString(3, newProperty.getType());
      query.setInt(4, newProperty.getBedrooms());
      query.setInt(5, newProperty.getBathrooms());

      int furnishedint = 0;
      if (newProperty.isFurnished()) furnishedint = 1;
      query.setInt(6, furnishedint);

      query.setString(7, newProperty.getQuadrant());
      query.setString(8, newProperty.getStatus());
      query.setString(9, newProperty.getExpirydate());
      System.out.println(query.toString());
      int rowcount = query.executeUpdate();
      System.out.println("Success - " + rowcount + " rows affected.");
    } finally {
      close(query, results);
    }
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

  public static void main(String[] args) throws Exception {
    RentalDatabaseObject dao = new RentalDatabaseObject();
    //System.out.println(dao.getAllUsers());
    //System.out.println(dao.searchUsername("moussavifan"));
    //System.out.println(dao.searchProperties("apartment", 1, 1, "NE", true));
    //System.out.println(dao.getAllProperties());
    dao.updatePropertyStatus();
  }
}
