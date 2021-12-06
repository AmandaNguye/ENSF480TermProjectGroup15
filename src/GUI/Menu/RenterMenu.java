package src.GUI.Menu;

import src.GUI.Tabs.SearchPropertyForm;
import src.GUI.Tabs.ViewNotificationWindow;

public class RenterMenu extends Menu {

  public RenterMenu(String user) {
    /**
     * Create the frame.
     */
    super("Renter Menu");
    greeting.setText("Welcome " + user);
    this.add(greeting);
    panel1 = new SearchPropertyForm();
    panel2 = new ViewNotificationWindow();
    tabs.add("Search", panel1);
    tabs.add("See Notifications", panel2);
    this.add(tabs);
    this.setLayout(null);
  }
}
