package src.Entities;

public class Notification {

  int subscriptionID;
  int listingID;
  String renter;

  public Notification(int subscriptionID, int listingID, String renter) {
    this.subscriptionID = subscriptionID;
    this.listingID = listingID;
    this.renter = renter;
  }

  public int getSubscriptionID() {
    return subscriptionID;
  }

  public void setSubscriptionID(int subscriptionID) {
    this.subscriptionID = subscriptionID;
  }

  public int getListingID() {
    return listingID;
  }

  public void setListingID(int listingID) {
    this.listingID = listingID;
  }

  public String getRenter() {
    return renter;
  }

  public void setRenter(String renter) {
    this.renter = renter;
  }
}
