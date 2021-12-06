package src.GUI.Menu;

import src.GUI.Tabs.ManageStateListingForm;
import src.GUI.Tabs.PayFeesForm;
import src.GUI.Tabs.RegisterPropertyForm;
import src.GUI.Tabs.ViewEmailWindow;

public class LandlordMenu extends Menu {

  /**
   * Launch the application.
   */
  public LandlordMenu(String user) {
    /**
     * Create the frame.
     */
    super("Landlord Menu");
    greeting.setText("Welcome " + user);
    this.add(greeting);
    panel1 = new RegisterPropertyForm(user);
    panel2 = new PayFeesForm();
    panel3 = new ManageStateListingForm();
    panel4 = new ViewEmailWindow();
    tabs.add("Register a New Property", panel1);
    tabs.add("Pay Fees", panel2);
    tabs.add("Manage Listings", panel3);
    tabs.add("View Email Messages", panel4);
    this.add(tabs);
    this.setLayout(null);
  }
}
