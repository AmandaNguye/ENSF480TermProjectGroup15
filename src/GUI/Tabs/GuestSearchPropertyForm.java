package src.GUI.Tabs;

import javax.swing.*;

public class GuestSearchPropertyForm extends GUI {

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
  private JButton searchButton;
  private JLabel status;

  public GuestSearchPropertyForm() {
    super();
    typeLabel = new JLabel("Type:");
    typeLabel.setBounds(10, 20, 80, 25);
    quadrantLabel = new JLabel("Quadrant:");
    quadrantLabel.setBounds(210, 20, 80, 25);
    bedroomsLabel = new JLabel("Bedrooms:");
    bedroomsLabel.setBounds(10, 50, 80, 25);
    bathroomsLabel = new JLabel("Bathrooms:");
    bathroomsLabel.setBounds(210, 50, 80, 25);
    furnishedLabel = new JLabel("Furnished:");
    furnishedLabel.setBounds(10, 80, 80, 25);

    String[] types = {
      "Apartment",
      "Attached House",
      "Detached House",
      "Townhouse",
    };
    typeBox = new JComboBox<String>(types);
    typeBox.setBounds(80, 20, 100, 25);
    String[] quadrant = { "NE", "NW", "SE", "SW" };
    quadrantBox = new JComboBox<String>(quadrant);
    quadrantBox.setBounds(280, 20, 100, 25);
    String[] bedrooms = { "1", "2", "3", "4", "5", "6", "7" };
    bedroomsBox = new JComboBox<String>(bedrooms);
    bedroomsBox.setBounds(80, 50, 100, 25);
    String[] bathrooms = { "1", "2", "3", "4", "5", "6", "7" };
    bathroomsBox = new JComboBox<String>(bathrooms);
    bathroomsBox.setBounds(280, 50, 100, 25);
    furnishedBox = new JCheckBox();
    furnishedBox.setBounds(80, 80, 100, 25);

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

    searchButton = new JButton("Search");
    searchButton.setBounds(150, 120, 100, 25);
    add(searchButton);
  }
}
