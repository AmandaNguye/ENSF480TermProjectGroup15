package src.GUI.Tabs;

import javax.swing.*;

public class RegisterPropertyForm extends GUI {

  private JLabel nameLabel;
  private JTextField nameText;
  private JLabel typeLabel;
  private JComboBox<String> typeBox;
  private JLabel bedroomsLabel;
  private JComboBox<String> bedroomsBox;
  private JLabel bathroomsLabel;
  private JComboBox<String> bathroomsBox;
  private JLabel furnishedLabel;
  private JCheckBox furnishedBox;
  private JLabel quadrantLabel;
  private JComboBox<String> quadrantBox;
  private JButton RegisterButton;

  //private JLabel status;

  public RegisterPropertyForm() {
    super();
    nameLabel = new JLabel("Title:");
    nameLabel.setBounds(80, 20, 80, 25);
    add(nameLabel);

    nameText = new JTextField(40);
    nameText.setBounds(150, 20, 300, 25);
    add(nameText);

    typeLabel = new JLabel("Type:");
    typeLabel.setBounds(80, 50, 80, 25);
    quadrantLabel = new JLabel("Quadrant:");
    quadrantLabel.setBounds(280, 50, 80, 25);
    bedroomsLabel = new JLabel("Bedrooms:");
    bedroomsLabel.setBounds(80, 80, 80, 25);
    bathroomsLabel = new JLabel("Bathrooms:");
    bathroomsLabel.setBounds(280, 80, 80, 25);
    furnishedLabel = new JLabel("Furnished:");
    furnishedLabel.setBounds(80, 110, 80, 25);

    String[] types = {
      "Apartment",
      "Attached House",
      "Detached House",
      "Townhouse",
    };
    typeBox = new JComboBox<String>(types);
    typeBox.setBounds(150, 50, 100, 25);
    String[] quadrant = { "NE", "NW", "SE", "SW" };
    quadrantBox = new JComboBox<String>(quadrant);
    quadrantBox.setBounds(350, 50, 100, 25);
    String[] bedrooms = { "1", "2", "3", "4", "5", "6", "7" };
    bedroomsBox = new JComboBox<String>(bedrooms);
    bedroomsBox.setBounds(150, 80, 100, 25);
    String[] bathrooms = { "1", "2", "3", "4", "5", "6", "7" };
    bathroomsBox = new JComboBox<String>(bathrooms);
    bathroomsBox.setBounds(350, 80, 100, 25);
    furnishedBox = new JCheckBox();
    furnishedBox.setBounds(150, 110, 100, 25);

    add(typeLabel);
    add(typeBox);
    add(bedroomsLabel);
    add(bedroomsBox);
    add(bathroomsLabel);
    add(bathroomsBox);
    add(furnishedLabel);
    add(furnishedBox);
    add(quadrantLabel);
    add(quadrantBox);

    RegisterButton = new JButton("Register");
    RegisterButton.setBounds(250, 150, 100, 25);
    add(RegisterButton);
  }
}
