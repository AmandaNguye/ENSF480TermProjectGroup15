package src.GUI.Tabs;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.Controllers.PayFeesController;
public class PayFeesForm extends GUI implements ActionListener
{
    private PayFeesController controller;
	private JButton confirm;
	private JLabel periodLabel;
	private JTextField periodAmount;
	private JLabel creditTypeLabel;
    private JComboBox<String> creditTypeBox;
    private JLabel creditNumberLabel;
    private JTextField creditCardNumber;
    private JLabel addressLabel;
    private JTextField address;
    public PayFeesForm()
    {
        super();

        confirm = new JButton("Confirm Payment");
        confirm.addActionListener(this);
        confirm.setBounds(350,250, 100 ,25);

        creditTypeLabel = new JLabel("Credit Card Type:");
	    creditTypeLabel.setBounds(10, 20, 80, 25);
	
	    String[] creditTypes = {"Mastercard", "Visa", "American Express"};
	    creditTypeBox = new JComboBox<String>(creditTypes);
	    creditTypeBox.setBounds(80, 20, 100, 25);
	    //creditTypeBox.addActionListener(this);
	
	    creditNumberLabel = new JLabel("Enter your credit card number:");
	    creditNumberLabel.setBounds(10, 70, 80, 25);
	
	    creditCardNumber = new JTextField("Type in here");
	    creditCardNumber.setBounds(80, 70, 200, 25);
	    
	    addressLabel = new JLabel("Address your paying fee for:");
	    addressLabel.setBounds(210, 120, 80, 25);
	    
	    address = new JTextField("Type in here");
	    address.setBounds(280, 120, 200, 25);
	    
	    periodLabel = new JLabel("How many periods would you like to pay for?");
	    periodLabel.setBounds(280, 170, 80, 25);
	    
	    periodAmount = new JTextField("Type in here");
	    periodAmount.setBounds(350, 170, 200, 25);
        
        add(creditTypeLabel);
        add(creditTypeBox);
        add(creditNumberLabel);
        add(creditCardNumber);
        add(addressLabel);
        add(address);
        add(periodLabel);
        add(periodAmount);
        add(confirm);
        
    }
	
    public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String addressTake = address.getText();
		//System.out.println(addressTake);
		String periodTake = periodAmount.getText();
		//System.out.println(periodTake);
	}
}
