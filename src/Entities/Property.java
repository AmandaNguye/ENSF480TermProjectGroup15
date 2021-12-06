package src.Entities;

public class Property {

  private int id;
  private String address;
  private String owner;
  private String type;
  private int bedrooms;
  private int bathrooms;
  private boolean furnished;
  private String quadrant;
  private String status;
  private String expirydate;

  public Property(
    int id,
    String address,
    String owner,
    String type,
    int bedrooms,
    int bathrooms,
    boolean furnished,
    String quadrant,
    String status,
    String expirydate
  ) {
    this.id = id;
    this.address = address;
    this.owner = owner;
    this.type = type;
    this.bedrooms = bedrooms;
    this.bathrooms = bathrooms;
    this.furnished = furnished;
    this.quadrant = quadrant;
    this.status = status;
    this.expirydate = expirydate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getBedrooms() {
    return bedrooms;
  }

  public void setBedrooms(int bedrooms) {
    this.bedrooms = bedrooms;
  }

  public int getBathrooms() {
    return bathrooms;
  }

  public void setBathrooms(int bathrooms) {
    this.bathrooms = bathrooms;
  }

  public boolean isFurnished() {
    return furnished;
  }

  public void setFurnished(boolean furnished) {
    this.furnished = furnished;
  }

  public String getQuadrant() {
    return quadrant;
  }

  public void setQuadrant(String quadrant) {
    this.quadrant = quadrant;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getExpirydate() {
    return expirydate;
  }

  public void setExpirydate(String expirydate) {
    this.expirydate = expirydate;
  }

  @Override
  public String toString() {
    String furnishedString = "false";
    if (furnished) {
      furnishedString = "true";
    }
    return String.format(
      "\nProperty [id=%s, address=%s, owner=%s, type=%s, bedrooms=%s, bathrooms=%s, furnished=%s, quadrant=%s, status=%s, expirydate=%s]",
      String.valueOf(id),
      address,
      owner,
      type,
      String.valueOf(bedrooms),
      String.valueOf(bathrooms),
      furnishedString,
      quadrant,
      status,
      expirydate
    );
  }
}
