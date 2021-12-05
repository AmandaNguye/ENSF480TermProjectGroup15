package src.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RenterMenu extends GUI {

  private JButton guestbtn;
  private JButton loginbtn;

  /**
   * Launch the application.
   */
  public RenterMenu() {
    /**
     * Create the frame.
     */
    super();
    JPanel panel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    flowLayout.setAlignment(FlowLayout.LEFT);
    contentPane.add(panel, BorderLayout.NORTH);

    JFrame temp = this;

    guestbtn = new JButton("Continue as Guest");
    guestbtn.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            temp.dispose();

            GuestSearchPropertyForm guestsearchframe = new GuestSearchPropertyForm();
            guestsearchframe.setVisible(true);
          } catch (Exception exc) {
            JOptionPane.showMessageDialog(
              RenterMenu.this,
              "Error: " + exc,
              "Error",
              JOptionPane.ERROR_MESSAGE
            );
          }
        }
      }
    );
    panel.add(guestbtn);

    loginbtn = new JButton("Login/Register");
    loginbtn.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            temp.dispose();
            LoginForm loginframe = new LoginForm();
            loginframe.setVisible(true);
          } catch (Exception exc) {
            JOptionPane.showMessageDialog(
              RenterMenu.this,
              "Error: " + exc,
              "Error",
              JOptionPane.ERROR_MESSAGE
            );
          }
        }
      }
    );
    panel.add(loginbtn);
  }
}
