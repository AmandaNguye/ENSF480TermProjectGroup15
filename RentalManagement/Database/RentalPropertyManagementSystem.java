package RentalManagement.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RentalPropertyManagementSystem {
	private Connection dbConnect;
//	private ResultSet results;
	private String DBurl = "jdbc:mysql://localhost/ensf480";
	private String username = "user";
	private String password = "pass1234";

	public RentalPropertyManagementSystem() {

	}

	public void initializeConnection() {
		try {
			dbConnect = DriverManager.getConnection(DBurl, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to connect to database");
		}
	}

	public String login(String username, String password) {
		try {
			String query = "SELECT * FROM USERS WHERE username = ? AND password = ?";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1, username);
			myStmt.setString(2, password);
			ResultSet results = myStmt.executeQuery();
			if(!results.next()) {
				return null;
			}
			return results.getString("accounttype");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean registerAccount(String username, String password, String accountType) {
		try {
			String query = "INSERT INTO USERS(username, password, accounttype) VALUES (?, ?, ?)";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1, username);
			myStmt.setString(2, password);
			myStmt.setString(3, accountType);
			myStmt.execute();
			myStmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean registerProperty(String owner, String type, int bedrooms, int bathrooms, String furnished, String quadrant, String address) {
		try {
			String query = "INSERT INTO properties(owner, type, bedrooms, bathrooms, furnished, quadrant, daysleft, address, status) VALUES (?, ?, ?, ?, ?, ?,'0000-00-00', ?, 'suspended')";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1, owner);
			myStmt.setString(2, type);
			myStmt.setInt(3, bedrooms);
			myStmt.setInt(4, bathrooms);
			myStmt.setString(5, furnished);
			myStmt.setString(6, quadrant);
			myStmt.setString(9, address);
			myStmt.execute();
			myStmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateFeeData(int amount, int period) {
		try {
			String query = "set @amount = ?, @period = ?";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setInt(1, amount);
			myStmt.setInt(2, period);
			myStmt.execute();
			myStmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet getFeeData() {
		try {
			String query = "select @amount, @period";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			return myStmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet searchPropety(String type, int bedrooms, int bathrooms, String furnished, String quadrant) {
		try {
			String query = "SELECT * FROM properties WHERE type = ? AND bedrooms = ? AND bathrooms = ? ANDfurnished = ? AND quadrant = ? AND daysleft > ? AND status = active";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1, type);
			myStmt.setInt(2, bedrooms);
			myStmt.setInt(3, bathrooms);
			myStmt.setString(4, furnished);
			myStmt.setString(5, quadrant);
			myStmt.setDate(6, Date.valueOf(LocalDate.now()));
			return myStmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean sendMessage(String receiverUsername, String message){
		try {
			String query = "INSERT INTO MESSAGES(receiver, message) VALUES (?, ?)";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1, receiverUsername);
			myStmt.setString(2, message);
			myStmt.execute();
			myStmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet getMessages(String username){
		try {
			String query = "SELECT * FROM MESSAGES WHERE receiver = ?";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1, username);
			ResultSet results = myStmt.executeQuery();
			if(!results.next()) {
				return null;
			}
			
			query = "DELETE FROM MESSAGES WHERE receiver = ?";
			myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1, username);
			myStmt.execute();
			myStmt.close();
		
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean subscribe(String type, int bedrooms, int bathrooms, String furnished, String quadrant){
		try {
			String query = "INSERT INTO MESSAGES(receiver, message) VALUES (?, ?)";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			myStmt.setString(1, receiverUsername);
			myStmt.setString(2, message);
			myStmt.execute();
			myStmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String args[]) {
		RentalPropertyManagementSystem rpms = new RentalPropertyManagementSystem();
		rpms.initializeConnection();
		System.out.println(rpms.login("landlord1", "ensf480"));
		System.out.println(rpms.registerAccount("renter10", "ensf481", "renter"));
	}
}
