package src.GUI.Menu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import RentalManagement.Property.Property;
import src.GUI.Tabs.GUI;


public class PropertyViewer extends Menu {
	
	JPanel propertyList;
	
	public PropertyViewer() {
		super("Property");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		JButton searchButton = new JButton("");
//		searchButton.setBounds(0, 0, 100, 50);
//		add(searchButton);
//		propertyList = new JPanel(new GridLayout(1, 10, 10,10));
		propertyList = new JPanel();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		propertyList.setLayout(flowLayout);
//		propertyList.setBounds(0, 20, WIDTH, HEIGHT);
		add(propertyList);
		
		
//		display();
//		searchButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//			}
//		});
		
	}
	
	public void display(ArrayList<Property> list){
		propertyList.removeAll();
		System.out.println(list.size());
		for(Property property : list) {
			JPanel propertyBox = new JPanel(new GridLayout(7, 1));
//			JPanel propertyBox = new JPanel();
			propertyBox.setMaximumSize(new Dimension(100, 100));
			
			JLabel addressLabel = new JLabel();
			addressLabel.setText("Address: " + property.address);
			propertyBox.add(addressLabel);
			
			JLabel typeLabel = new JLabel();
			typeLabel.setText(property.type);
			propertyBox.add(typeLabel);
			
			JLabel bedroomsLabel = new JLabel();
			bedroomsLabel.setText(Integer.toString(property.bedrooms));
			propertyBox.add(bedroomsLabel);
			
			JLabel bathroomsLabel = new JLabel();
			bathroomsLabel.setText(Integer.toString(property.bathrooms));
			propertyBox.add(bathroomsLabel);
			
			JLabel furnishedLabel = new JLabel();
			if(property.furnished) {
				furnishedLabel.setText("Furnished");
			}else {
				furnishedLabel.setText("Unfurnished");
			}
			propertyBox.add(furnishedLabel);
			
			JLabel typequadrant = new JLabel();
			typequadrant.setText(property.quadrant);
			propertyBox.add(typequadrant);
			
			propertyList.add(propertyBox,  BorderLayout.WEST);
			propertyList.add(Box.createHorizontalStrut(20),  BorderLayout.WEST);
		}
		setVisible(true);
	}
}
