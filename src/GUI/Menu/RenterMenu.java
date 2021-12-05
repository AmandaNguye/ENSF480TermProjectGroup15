package src.GUI.Menu;

import src.GUI.Tabs.SearchPropertyForm;
import src.GUI.Tabs.ViewNotificationWindow;

public class RenterMenu extends Menu {

  public RenterMenu() {
    /**
     * Create the frame.
     */
    super("Renter Menu");
    panel1 = new SearchPropertyForm();
    panel2 = new ViewNotificationWindow();
    tabs.add("Search", panel1);
    tabs.add("See Notifications", panel2);
    this.add(tabs);
    this.setLayout(null);
  }
}
