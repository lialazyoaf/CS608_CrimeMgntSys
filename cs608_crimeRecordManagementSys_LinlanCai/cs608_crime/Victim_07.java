/**
 * Created by: LINLAN CAI
 * Created on: 5:15:05 PM, Dec 14, 2023
 * File: Victim_07.java
 * 
 * Description: This file is subject to the terms and conditions of the MIT License.
 * See https://opensource.org/licenses/MIT for details.
 * Copyright (c) 2023 LINLAN CAI
 */
package cs608_crime;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 */
public class Victim_07 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable victimInfoTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Victim_07 frame = new Victim_07();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Victim_07() {
		setTitle("Victim Page - LinlanCai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new BorderLayout());

        // Create the top panel
        JPanel topPanel = new JPanel(new BorderLayout());

        // Create the Back button
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 30)); // Set button size
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Go back to the main page
                dispose();
                MainPageFrame mainPage = new MainPageFrame();
                mainPage.setVisible(true);
            }
        });
        topPanel.add(backButton, BorderLayout.WEST);

        // Create the Log Out button
        JButton logoutButton = new JButton("LogOut");
        logoutButton.setPreferredSize(new Dimension(100, 30)); // Set button size
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Return to the login page
                dispose();
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
        topPanel.add(logoutButton, BorderLayout.EAST);

        // Create Display Victims button
        JButton displayVictimsButton = new JButton("Display Victims");
        displayVictimsButton.setPreferredSize(new Dimension(150, 30)); // Set button size
        displayVictimsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display victim information in a table
                displayVictimInfoTable();
            }

            private void displayVictimInfoTable() {
                // Configure your database connection parameters
            	String jdbcUrl = "jdbc:mysql://localhost:3306/Crime_Record_Management";
                String usernameSQL = "root";
                String passwordSQL = "Pace1234@";

                try {
                    Connection connection = DriverManager.getConnection(jdbcUrl, usernameSQL, passwordSQL);
                    if (connection != null) {
                        System.out.println("Database connection successful!");
                    }

                    Statement statement = connection.createStatement();
                    String query = "SELECT * FROM Victim_Info"; // Customize your SQL query
                    ResultSet resultSet = statement.executeQuery(query);

                    DefaultTableModel tableModel = new DefaultTableModel();
                    tableModel.addColumn("Victim ID");
                    tableModel.addColumn("First Name");
                    tableModel.addColumn("Last Name");
                    tableModel.addColumn("Age");
                    tableModel.addColumn("Nationality");
                    tableModel.addColumn("Address");
                    tableModel.addColumn("Phone Number");
                    tableModel.addColumn("Alternate Phone Number");
                    tableModel.addColumn("Judge ID");
                    tableModel.addColumn("Court ID");

                    while (resultSet.next()) {
                        String victimID = resultSet.getString("Victim_id");
                        String firstName = resultSet.getString("First_name");
                        String lastName = resultSet.getString("Last_name");
                        int age = resultSet.getInt("Age");
                        String nationality = resultSet.getString("Nationality");
                        String address = resultSet.getString("Address");
                        String phoneNumber = resultSet.getString("Phone_no");
                        String alternatePhoneNumber = resultSet.getString("Alternate_phone_no");
                        String judgeID = resultSet.getString("Judge_id");
                        String courtID = resultSet.getString("Court_id");

                        tableModel.addRow(new Object[]{victimID, firstName, lastName, age, nationality, address, phoneNumber, alternatePhoneNumber, judgeID, courtID});
                    }

                    victimInfoTable.setModel(tableModel); // Set the table data

                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        topPanel.add(displayVictimsButton, BorderLayout.CENTER);

        contentPanel.add(topPanel, BorderLayout.NORTH);

        // Add your Victim_07 page content, such as buttons and other components
        // Add your Victim_07 page content here

        // Create a table to display victim information
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Victim ID");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Nationality");
        tableModel.addColumn("Address");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Alternate Phone Number");
        tableModel.addColumn("Judge ID");
        tableModel.addColumn("Court ID");

        victimInfoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(victimInfoTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Footer label
        JLabel footerLabel = new JLabel("- Crime Management System - CS 608 -", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font and size
        contentPanel.add(footerLabel, BorderLayout.SOUTH);

        add(contentPanel);
	}
}

