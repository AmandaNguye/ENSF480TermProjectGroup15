package RentalManagement.GUI;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class LandlordMenu extends GUI implements ActionListener
{
    int count = 0;
	JLabel label;
	JFrame frame;
	JPanel panel;
    public void createLandlordMenu()
    {
        frame = new JFrame();
        panel = new JPanel();
        JButton button = new JButton("List Property");
        JButton button2 = new JButton("Pay Fee");
        button.addActionListener(this);
        label = new JLabel("Number of clicks: 0");
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(button2);
        panel.add(label);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Landlord Menu");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        LandlordMenu a = new LandlordMenu();
        a.createLandlordMenu();
    }
    
}