package src.GUI.Tabs;

import javax.swing.*;

public class ManageFeesForm extends GUI {

  private JButton UpdateButton;

  public ManageFeesForm() {
    super();
    UpdateButton = new JButton("Update");
    UpdateButton.setBounds(150, 150, 100, 25);
    add(UpdateButton);
  }
}
