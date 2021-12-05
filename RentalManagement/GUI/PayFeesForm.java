package RentalManagement.GUI;
import javax.swing.*;
public class PayFeesForm extends GUI
{
    private JLabel creditTypeLabel;
    private JComboBox<String> creditTypeBox;
    private JLabel creditNumberLabel;
    private JTextField creditCardNumber;
    public PayFeesForm()
    {
        super();
        creditTypeLabel = new JLabel("Credit Card Type:");
        creditTypeLabel.setBounds(10, 20, 80, 25);

        String[] creditTypes = {"Mastercard", "Visa", "American Express"};
        creditTypeBox = new JComboBox<String>(creditTypes);
        creditTypeBox.setBounds(80, 20, 100, 25);

        creditNumberLabel = new JLabel("Enter your credit card number:");
        creditNumberLabel.setBounds(10, 70, 80, 25);

        creditCardNumber = new JTextField("Type in here");
        creditCardNumber.setBounds(80, 70, 200, 25);
    }
}