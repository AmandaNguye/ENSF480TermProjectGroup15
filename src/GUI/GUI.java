package src.GUI;

import javax.swing.*;
import javax.swing.border.*;

public class GUI extends JFrame {

  protected JPanel contentPane;

  public GUI() {
    setTitle("Employee Search App");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
  }
}
