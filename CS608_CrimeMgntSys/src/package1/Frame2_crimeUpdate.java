/**
 * Created by: LINLAN CAI
 * Created on: 2:59:13 PM, Nov 3, 2023
 * File: Frame2.java
 * 
 * Description: This file is subject to the terms and conditions of the MIT License.
 * See https://opensource.org/licenses/MIT for details.
 * Copyright (c) 2023 LINLAN CAI
 */
package package1;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
public class Frame2_crimeUpdate extends JFrame {

	private static final long serialVersionUID = 1L;
		private JTextField textFieldCrimeID;
	    private JTextField textFieldCrimeType;
	    private JCheckBox checkBoxWeaponUsed;
	    private JTextField textFieldWeaponType;
	    private JTextField textFieldCrimeLocation;
	    private JTextField textFieldCriminalID;
	    private JTextField textFieldVictimID;
	    private JFormattedTextField formattedTextFieldCrimeDate; // ensure this is formatted for date input
	    private JFormattedTextField formattedTextFieldCrimeTime; // ensure this is formatted for timestamp input


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 String url = "jdbc:mysql://localhost:3306/cs608CrimeSys";
	     String username = "linlancai";
	     String password = "cs608";
	     
	     EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2_crimeUpdate frame = new Frame2_crimeUpdate();
					frame.setVisible(true);

					Connection connection = DriverManager.getConnection(url, username, password);
		            System.out.println("Connected to the database!");
		            // Perform database operations here
		            // Don't forget to close the connection when done
		            connection.close();
		            
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Frame2_crimeUpdate() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400); // Adjusted size to fit new layout
        getContentPane().setLayout(new BorderLayout(10, 10)); // BorderLayout for the main layout

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS)); // BoxLayout for the input fields

        
        // Crime ID Panel
        JPanel crimeIDPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblCrimeID = new JLabel("Crime ID:");
        textFieldCrimeID = new JTextField(20);
        crimeIDPanel.add(lblCrimeID);
        crimeIDPanel.add(textFieldCrimeID);
        
        //Panel for Crime type
        JPanel crimeTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblCrimeType = new JLabel("Crime Type:");
        JTextField textFieldCrimeType = new JTextField(20);
        crimeTypePanel.add(lblCrimeType);
        crimeTypePanel.add(textFieldCrimeType);
        
        // Criminal ID Panel
        JPanel criminalIDPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblCriminalID = new JLabel("Criminal ID:");
        textFieldCriminalID = new JTextField(20);
        criminalIDPanel.add(lblCriminalID);
        criminalIDPanel.add(textFieldCriminalID);
        
        // Victim ID Panel
        JPanel victimIDPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblVictimID = new JLabel("Victim ID:");
        textFieldVictimID = new JTextField(20); // Initialize the class member variable
        victimIDPanel.add(lblVictimID);
        victimIDPanel.add(textFieldVictimID);
        
        // Crime Date Panel
        JPanel crimeDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblCrimeDate = new JLabel("Crime Date (yyyy-MM-dd):");
        formattedTextFieldCrimeDate = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
        formattedTextFieldCrimeDate.setColumns(10); // Initialize the class member variable
        crimeDatePanel.add(lblCrimeDate);
        crimeDatePanel.add(formattedTextFieldCrimeDate);
        // Crime Time Panel
        JPanel crimeTimePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblCrimeTime = new JLabel("Crime Time (HH:mm:ss):");
        formattedTextFieldCrimeTime = new JFormattedTextField(new SimpleDateFormat("HH:mm:ss"));
        formattedTextFieldCrimeTime.setColumns(10); // Initialize the class member variable
        crimeTimePanel.add(lblCrimeTime);
        crimeTimePanel.add(formattedTextFieldCrimeTime);
        
        // Crime Location Panel
        JPanel crimeLocationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblCrimeLocation = new JLabel("Crime Location:");
        textFieldCrimeLocation = new JTextField(20); // Initialize the class member variable
        crimeLocationPanel.add(lblCrimeLocation);
        crimeLocationPanel.add(textFieldCrimeLocation);

        // Panel for Weapon Used Check box
        JPanel weaponUsedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox checkBoxWeaponUsed = new JCheckBox("Weapon Used");
        weaponUsedPanel.add(checkBoxWeaponUsed);
        // Panel for Weapon Type
        JPanel weaponTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblWeaponType = new JLabel("Weapon Type:");
        JTextField textFieldWeaponType = new JTextField(20);
        weaponTypePanel.add(lblWeaponType);
        weaponTypePanel.add(textFieldWeaponType);
        
        // Bottom Panel for the text "CS 608 - Crime Record Management System"
        JPanel boPanel = new JPanel();
        boPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center alignment
        JTextPane textPane = new JTextPane();
        textPane.setText("CS 608 - Crime Record Management System");
        textPane.setEditable(false); // Make the text pane non-editable
        textPane.setOpaque(false); // Set background to transparent
        boPanel.add(textPane);
        
     // Add all input panels to the inputPanel
     inputPanel.add(crimeIDPanel);
     inputPanel.add(crimeTypePanel);
     inputPanel.add(criminalIDPanel);
     inputPanel.add(crimeIDPanel);
     inputPanel.add(victimIDPanel);
     inputPanel.add(crimeDatePanel);
     inputPanel.add(crimeTimePanel);
     inputPanel.add(crimeLocationPanel);
     inputPanel.add(weaponUsedPanel);
     inputPanel.add(weaponTypePanel);
     
     // Button Panel
     JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
     JButton btnNewButton = new JButton("Add Record");
     btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Your logic to handle the addition of a new crime record
             String crimeID = textFieldCrimeID.getText();
             String crimeType = textFieldCrimeType.getText();
             boolean weaponUsed = checkBoxWeaponUsed.isSelected();
             String weaponType = textFieldWeaponType.getText();
             String crimeDate = formattedTextFieldCrimeDate.getText();
             String crimeTime = formattedTextFieldCrimeTime.getText();
             String crimeLocation = textFieldCrimeLocation.getText();
             String criminalID = textFieldCriminalID.getText();
             String victimID = textFieldVictimID.getText();
             // Implement the update logic here
             // This could involve creating a new CrimeInfo object and passing it to a service class
             // that handles the database update, or directly updating the database here.
          // Create a formatted string for the crime record
             String crimeRecord = String.format(
                 "INSERT INTO crime_info (crime_id, crime_type, weapon_used, weapon_type, crime_date, crime_time, crime_location, criminal_id, victim_id) " +
                 "VALUES ('%s', '%s', %b, '%s', '%s', '%s', '%s', '%s', '%s');",
                 crimeID, crimeType, weaponUsed, weaponType, crimeDate, crimeTime, crimeLocation, criminalID, victimID
             );

             // File path for the SQL file
             String filePath = "crime_info.sql";

             try {
                 // Open the file for writing (append mode)
                 FileWriter fileWriter = new FileWriter(filePath, true);
                 PrintWriter printWriter = new PrintWriter(fileWriter);

                 // Write the formatted SQL statement to the file
                 printWriter.println(crimeRecord);

                 // Close the file
                 printWriter.close();

                 // Inform the user that the data has been added to the file
                 JOptionPane.showMessageDialog(null, "Crime record added to " + filePath);
             } catch (IOException ex) {
                 ex.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
             }
         }
     });
     buttonPanel.add(btnNewButton);	
	     
  // Add the input panel and button panel to the content pane
     getContentPane().add(inputPanel, BorderLayout.CENTER);
     getContentPane().add(buttonPanel, BorderLayout.SOUTH);
     getContentPane().add(boPanel, BorderLayout.PAGE_START);
    
     
     pack();
        
	}
}
