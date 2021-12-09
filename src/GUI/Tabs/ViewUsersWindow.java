package src.GUI.Tabs;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import src.Entities.*;

/**
 * ViewUsersWindow builds and displays the user viewer tab used to view all users in the database.
 */
public class ViewUsersWindow extends GUI {

  private JButton viewUsersButton;
  private JScrollPane scrollPane;
  private JTable userTable;

	/**
	 * Constructor
	 */
  public ViewUsersWindow() {
    super();
    viewUsersButton = new JButton("Show Users");
    viewUsersButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          List<User> users = null;
          try {
            users = rentalDAO.getAllUsers();
            UserTableModel model = new UserTableModel(users);
            userTable.setModel(model);
          } catch (Exception exc) {
            JOptionPane.showMessageDialog(
              ViewUsersWindow.this,
              "Error: " + exc,
              "Error",
              JOptionPane.ERROR_MESSAGE
            );
          }
        }
      }
    );
    viewUsersButton.setBounds(200, 40, 130, 25);
    add(viewUsersButton);
    scrollPane = new JScrollPane();
    scrollPane.setHorizontalScrollBarPolicy(
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    scrollPane.setVerticalScrollBarPolicy(
      JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    );

    scrollPane.setBounds(20, 90, 500, 230);
    add(scrollPane, BorderLayout.CENTER);

    userTable = new JTable();
    scrollPane.setViewportView(userTable);
  }
}
