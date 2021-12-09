package src.GUI.Menu;

import java.awt.Font;
import javax.swing.*;

/**
 * Menu is a parent class that contains variables common to all different menus.
 */
public class Menu extends JFrame {

  protected JLabel greeting;
  protected JPanel panel1;
  protected JPanel panel2;
  protected JPanel panel3;
  protected JPanel panel4;
  protected JPanel panel5;
  protected JTabbedPane tabs;

	/**
	 * Constructor
	 */
  Menu(String title) {
    setTitle(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 600);
    greeting = new JLabel();
    greeting.setFont(new Font("Arial", Font.BOLD, 20));
    greeting.setBounds(20, 10, 400, 50);
    tabs = new JTabbedPane();
    tabs.setBounds(20, 60, 550, 480);
    setVisible(true);
  }
}
