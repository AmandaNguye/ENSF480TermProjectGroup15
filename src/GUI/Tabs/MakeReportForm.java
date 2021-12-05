package src.GUI.Tabs;

import javax.swing.*;

public class MakeReportForm extends GUI {

  private JButton makeReportButton;

  public MakeReportForm() {
    super();
    makeReportButton = new JButton("Make Report");
    makeReportButton.setBounds(150, 150, 100, 25);
    add(makeReportButton);
  }
}
