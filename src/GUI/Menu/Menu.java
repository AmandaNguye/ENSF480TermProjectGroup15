package src.GUI.Menu;

import javax.swing.*;

public class Menu extends JFrame {

  protected JPanel panel1;
  protected JPanel panel2;
  protected JPanel panel3;
  protected JPanel panel4;
  protected JPanel panel5;
  protected JTabbedPane tabs;

  Menu(String s) {
    setTitle(s);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(450, 450);
    tabs = new JTabbedPane();
    tabs.setBounds(20, 20, 400, 350);
    setVisible(true);
  }
}
