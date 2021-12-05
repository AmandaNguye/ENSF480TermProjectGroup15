package src.GUI.Menu;

import src.GUI.Tabs.ManageStateListingForm;
import src.GUI.Tabs.PayFeesForm;
import src.GUI.Tabs.RegisterPropertyForm;

public class LandlordMenu extends Menu {

  /**
   * Launch the application.
   */
  public LandlordMenu() {
    /**
     * Create the frame.
     */
    super("Landlord Menu");
    panel1 = new RegisterPropertyForm();
    panel2 = new PayFeesForm();
    panel3 = new ManageStateListingForm();
    tabs.add("Register a New Property", panel1);
    tabs.add("Pay Fees", panel2);
    tabs.add("Manage Listings", panel3);
    this.add(tabs);
    this.setLayout(null);
  }
}
