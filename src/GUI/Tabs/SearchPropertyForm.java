package src.GUI.Tabs;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import src.Entities.*;

public class SearchPropertyForm extends GUI {

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
  private JScrollPane scrollPane;
  private JTable propertyTable;

  //private JLabel status;

  public SearchPropertyForm() {
    super();
    typeLabel = new JLabel("Type:");
    typeLabel.setBounds(10, 20, 80, 25);
    quadrantLabel = new JLabel("Quadrant:");
    quadrantLabel.setBounds(260, 20, 80, 25);
    bedroomsLabel = new JLabel("Bedrooms:");
    bedroomsLabel.setBounds(10, 50, 80, 25);
    bathroomsLabel = new JLabel("Bathrooms:");
    bathroomsLabel.setBounds(260, 50, 80, 25);
    furnishedLabel = new JLabel("Furnished:");
    furnishedLabel.setBounds(10, 80, 80, 25);

    String[] types = {
      "Any",
      "Apartment",
      "Attached House",
      "Detached House",
      "Townhouse",
    };
    typeBox = new JComboBox<String>(types);
    typeBox.setBounds(80, 20, 100, 25);
    String[] quadrant = { "Any", "NE", "NW", "SE", "SW" };
    quadrantBox = new JComboBox<String>(quadrant);
    quadrantBox.setBounds(330, 20, 100, 25);
    String[] bedrooms = { "0", "1", "2", "3", "4", "5", "6", "7" };
    bedroomsBox = new JComboBox<String>(bedrooms);
    bedroomsBox.setBounds(80, 50, 100, 25);
    String[] bathrooms = { "0", "1", "2", "3", "4", "5", "6", "7" };
    bathroomsBox = new JComboBox<String>(bathrooms);
    bathroomsBox.setBounds(330, 50, 100, 25);
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
    searchButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String type = typeBox.getSelectedItem().toString().toLowerCase();
          int bedrooms = Integer.parseInt(
            bedroomsBox.getSelectedItem().toString()
          );
          int bathrooms = Integer.parseInt(
            bathroomsBox.getSelectedItem().toString()
          );
          String quadrant = quadrantBox.getSelectedItem().toString();
          Boolean furnished = furnishedBox.isSelected();
          List<Property> properties = null;
          try {
            properties =
              rentalDAO.searchProperties(
                type,
                bedrooms,
                bathrooms,
                quadrant,
                furnished
              );
            SearchPropertyTableModel model = new SearchPropertyTableModel(
              properties
            );
            propertyTable.setModel(model);
          } catch (Exception exc) {
            JOptionPane.showMessageDialog(
              SearchPropertyForm.this,
              "Error: " + exc,
              "Error",
              JOptionPane.ERROR_MESSAGE
            );
          }
        }
      }
    );
    searchButton.setBounds(210, 110, 100, 25);
    add(searchButton);

    scrollPane = new JScrollPane();
    scrollPane.setHorizontalScrollBarPolicy(
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    scrollPane.setVerticalScrollBarPolicy(
      JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    );

    scrollPane.setBounds(20, 150, 500, 230);
    add(scrollPane, BorderLayout.CENTER);

    propertyTable = new JTable();
    scrollPane.setViewportView(propertyTable);
  }
}
