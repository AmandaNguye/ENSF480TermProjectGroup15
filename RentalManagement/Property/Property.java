package RentalManagement.Property;

import java.time.LocalDate;

public class Property {
	int id;
	String owner;
	String address;
	String type;
	int bedrooms;
	int bathrooms;
	boolean furnished;
	String quadrant;
	LocalDate daysleft;
	String state;

	public Property(int id, String owner, String address, String type, int bedrooms, int bathrooms, boolean furnished, String quadrant,
			LocalDate daysleft, String state) {
	this.id = id;
	this.owner = owner;
	this.address = address;
	this.type = type;
	this.bedrooms = bedrooms;
	this.bathrooms = bathrooms;
	this.furnished = furnished;
	this.quadrant = quadrant;
	this.daysleft = daysleft;
	this.state = state;
	}
}
