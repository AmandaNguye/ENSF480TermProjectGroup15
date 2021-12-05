package src.GUI.Menu;

import src.GUI.Tabs.GuestSearchPropertyForm;
import src.GUI.Tabs.LoginForm;

public class GuestMenu extends Menu {

  /**
   * Launch the application.
   */
  public GuestMenu() {
    /**
     * Create the frame.
     */
    super("Start Menu");
    panel1 = new LoginForm();
    panel2 = new GuestSearchPropertyForm();
    tabs.add("Login/Register", panel1);
    tabs.add("Search as Guest", panel2);
    this.add(tabs);
    this.setLayout(null);
  }
}
