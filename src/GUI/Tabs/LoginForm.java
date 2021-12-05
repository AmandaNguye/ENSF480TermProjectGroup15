package src.GUI.Tabs;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import src.Database.RentalDatabaseObject;
import src.Entities.User;
import src.GUI.Menu.LandlordMenu;
import src.GUI.Menu.ManagerMenu;
import src.GUI.Menu.RenterMenu;

public class LoginForm extends GUI {

  private JLabel usernameLabel;
  private JTextField usernameText;
  private JLabel passwordLabel;
  private JTextField passwordText;
  private JButton loginButton;
  private JLabel status;

  public LoginForm() {
    // create the DAO
    super();
    usernameLabel = new JLabel("User");
    usernameLabel.setBounds(10, 20, 80, 25);
    add(usernameLabel);

    usernameText = new JTextField(20);
    usernameText.setBounds(100, 20, 165, 25);
    add(usernameText);

    passwordLabel = new JLabel("Password");
    passwordLabel.setBounds(10, 50, 80, 25);
    add(passwordLabel);

    passwordText = new JPasswordField(20);
    passwordText.setBounds(100, 50, 165, 25);
    add(passwordText);

    loginButton = new JButton("Login");
    loginButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            String username = usernameText.getText();
            String password = passwordText.getText();
            User user = null;

            if (username == null || username.trim().length() == 0) {
              JOptionPane.showMessageDialog(null, "Username field empty.");
            } else {
              List<User> tempUsers = rentalDAO.searchUsername(username);
              if (tempUsers.size() == 0) {
                JOptionPane.showMessageDialog(
                  null,
                  "Username could not be found."
                );
              } else {
                user = tempUsers.get(0);

                if (password == null || password.length() <= 0) {
                  JOptionPane.showMessageDialog(null, "Password field empty.");
                } else if (user.getPassword().equals(password)) {
                  if (user.getAccountType().equals("renter")) {
                    RenterMenu frame = new RenterMenu();
                    frame.setVisible(true);
                  }
                  if (user.getAccountType().equals("landlord")) {
                    LandlordMenu frame = new LandlordMenu();
                    frame.setVisible(true);
                  }
                  if (user.getAccountType().equals("manager")) {
                    ManagerMenu frame = new ManagerMenu();
                    frame.setVisible(true);
                  }
                } else {
                  JOptionPane.showMessageDialog(null, "Wrong password.");
                }
              }
            }
          } catch (Exception exc) {
            JOptionPane.showMessageDialog(
              LoginForm.this,
              "Error: " + exc,
              "Error",
              JOptionPane.ERROR_MESSAGE
            );
          }
        }
      }
    );

    loginButton.setBounds(110, 100, 80, 25);
    add(loginButton);

    status = new JLabel("");
    status.setBounds(100, 130, 100, 25);
    add(status);
  }
}
