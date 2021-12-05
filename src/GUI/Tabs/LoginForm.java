package src.GUI.Tabs;

import javax.swing.*;

public class LoginForm extends GUI {

  private JLabel usernameLabel;
  private JTextField usernameText;
  private JLabel passwordLabel;
  private JTextField passwordText;
  private JButton button;
  private JLabel status;

  public LoginForm() {
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

    button = new JButton("Login");
    button.setBounds(110, 100, 80, 25);
    //ACTION
    add(button);

    status = new JLabel("");
    status.setBounds(100, 130, 100, 25);
    add(status);
  }
}
