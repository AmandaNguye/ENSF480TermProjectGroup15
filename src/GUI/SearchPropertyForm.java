package src.GUI;

import java.awt.*;
import javax.swing.*;

public class SearchPropertyForm {

  private JPanel contentPane;
  private JTextField lastNameTextField;
  private JButton btnSearch;
  private JScrollPane scrollPane;
  private JTable table;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          try {
            GuestMenu frame = new GuestMenu();
            frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    );
  }

  public SearchPropertyForm() {
    /**
     * Create the frame.
     */
    JFrame frame = new JFrame("A Simple GUI");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLocation(430, 100);

    JPanel panel = new JPanel();

    frame.add(panel);

    JLabel quadrantlbl = new JLabel("Quadrant:");
    quadrantlbl.setVisible(true);

    panel.add(quadrantlbl);

    String[] quadrant = { "NE", "NW", "SE", "SW" };

    final JComboBox<String> cb = new JComboBox<String>(quadrant);

    cb.setVisible(true);
    panel.add(cb);

    JButton btn = new JButton("OK");
    panel.add(btn);
  }
}
