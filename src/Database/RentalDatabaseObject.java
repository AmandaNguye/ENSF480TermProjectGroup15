package src.Database;

import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import RentalManagement.Property.Property;
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
  
	public ArrayList<Property> searchPropety(String type, int bedrooms, int bathrooms, boolean furnished, String quadrant) {
		try {
			String query = "SELECT * FROM properties WHERE type = ? AND bedrooms = ? AND bathrooms = ? AND furnished = ? AND quadrant = ? AND daysleft > ? AND state = 'active'";
//			String query = "SELECT * FROM properties WHERE type = ? AND bedrooms = ? AND bathrooms = ? AND furnished = ? AND quadrant = ?";
			
			PreparedStatement myStmt = myConn.prepareStatement(query);
			myStmt.setString(1, type);
			myStmt.setInt(2, bedrooms);
			myStmt.setInt(3, bathrooms);
			myStmt.setBoolean(4, furnished);
			myStmt.setString(5, quadrant);
			myStmt.setDate(6, Date.valueOf(LocalDate.now()));
			System.out.println(myStmt);
			return parsePropertyResultSet(myStmt.executeQuery());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Property> parsePropertyResultSet(ResultSet results) throws SQLException {
		ArrayList<Property> data = new ArrayList<Property>();
		while (results.next()) {
			data.add(new Property(results.getInt("id"), results.getString("owner"), results.getString("address"),
					results.getString("type"), results.getInt("bedrooms"), results.getInt("bathrooms"),
					results.getBoolean("furnished"), results.getString("quadrant"), results.getDate("daysleft").toLocalDate(), results.getString("state")));
		}
		return data;
	}
  
}
