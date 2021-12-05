package src.GUI.Tabs;

import javax.swing.*;
import src.Database.RentalDatabaseObject;

public class GUI extends JPanel {

  protected RentalDatabaseObject rentalDAO;

  GUI() {
    try {
      rentalDAO = new RentalDatabaseObject();
    } catch (Exception exc) {
      JOptionPane.showMessageDialog(
        this,
        "Error: " + exc,
        "Error",
        JOptionPane.ERROR_MESSAGE
      );
    }
    setLayout(null);
  }
}
