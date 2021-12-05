package src.GUI.Menu;

import java.awt.Font;
import javax.swing.*;

public class Menu extends JFrame {

  protected JLabel greeting;
  protected JPanel panel1;
  protected JPanel panel2;
  protected JPanel panel3;
  protected JPanel panel4;
  protected JPanel panel5;
  protected JTabbedPane tabs;

  Menu(String title) {
    setTitle(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(450, 450);
    greeting = new JLabel();
    greeting.setText("Rental Management Property System");
    greeting.setFont(new Font("Arial", Font.BOLD, 20));
    greeting.setBounds(20, 10, 400, 50);
    tabs = new JTabbedPane();
    tabs.setBounds(20, 60, 400, 320);
    setVisible(true);
  }
}
