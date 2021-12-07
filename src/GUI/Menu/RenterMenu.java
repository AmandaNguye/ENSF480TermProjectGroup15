package src.GUI.Menu;

import src.GUI.Tabs.SearchPropertyForm;
import src.GUI.Tabs.ViewEmailWindow;
import src.GUI.Tabs.ViewNotificationWindow;
import src.GUI.Tabs.ViewSubscriptionsWindow;

public class RenterMenu extends Menu {

  public RenterMenu(String user) {
    /**
     * Create the frame.
     */
    super("Renter Menu");
    greeting.setText("Welcome " + user);
    this.add(greeting);
    panel1 = new SearchPropertyForm(user);
    panel2 = new ViewNotificationWindow();
    panel3 = new ViewSubscriptionsWindow();
    panel4 = new ViewEmailWindow(user);

    tabs.add("Search Properties", panel1);
    tabs.add("See Notifications", panel2);
    tabs.add("Manage Subscriptions", panel3);
    tabs.add("View Email Messages", panel4);
    this.add(tabs);
    this.setLayout(null);
  }
}
