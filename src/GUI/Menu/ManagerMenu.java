package src.GUI.Menu;

import src.GUI.Tabs.MakeReportForm;
import src.GUI.Tabs.ManageFeesForm;
import src.GUI.Tabs.ManageStateListingForm;
import src.GUI.Tabs.ViewUsersWindow;

public class ManagerMenu extends Menu {

  /**
   * Launch the application.
   */
  public ManagerMenu(String user) {
    /**
     * Create the frame.
     */
    super("Manager Menu");
    greeting.setText("Welcome " + user);
    this.add(greeting);
    panel1 = new MakeReportForm();
    panel2 = new ManageFeesForm();
    panel3 = new ManageStateListingForm();
    panel4 = new ViewUsersWindow();
    tabs.add("Request a Report", panel1);
    tabs.add("Manage Fees", panel2);
    tabs.add("Manage Listings", panel3);
    tabs.add("Access Users", panel4);
    this.add(tabs);
    this.setLayout(null);
  }
}
