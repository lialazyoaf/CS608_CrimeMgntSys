/**
 * Created by: LINLAN CAI
 * Created on: 5:11:22 PM, Dec 14, 2023
 * File: Prison_08.java
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
public class Prison_08 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable prisonInfoTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prison_08 frame = new Prison_08();
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
	public Prison_08() {
		setTitle("Prison Page - LinlanCai");
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

        // Create Display Prison button
        JButton displayPrisonButton = new JButton("Display Prison");
        displayPrisonButton.setPreferredSize(new Dimension(150, 30)); // Set button size
        displayPrisonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display prison information in a table
                displayPrisonInfoTable();
            }

            private void displayPrisonInfoTable() {
            	String jdbcUrl = "jdbc:mysql://localhost:3306/Crime_Record_Management";
                String usernameSQL = "root";
                String passwordSQL = "Pace1234@";

                try {
                    Connection connection = DriverManager.getConnection(jdbcUrl, usernameSQL, passwordSQL);
                    if (connection != null) {
                        System.out.println("Database connection successful!");
                    }

                    Statement statement = connection.createStatement();
                    String query = "SELECT * FROM Prison_Info"; // Customize your SQL query
                    ResultSet resultSet = statement.executeQuery(query);

                    DefaultTableModel tableModel = new DefaultTableModel();
                    tableModel.addColumn("Prison ID");
                    tableModel.addColumn("Prison Name");
                    tableModel.addColumn("Phone No");
                    tableModel.addColumn("Prison Address");
                    tableModel.addColumn("Criminal ID");

                    while (resultSet.next()) {
                        String prisonID = resultSet.getString("Prison_id");
                        String prisonName = resultSet.getString("Prison_name");
                        String phoneNo = resultSet.getString("Phone_no");
                        String prisonAddress = resultSet.getString("Prison_address");
                        String criminalID = resultSet.getString("Criminal_id");

                        tableModel.addRow(new String[]{prisonID, prisonName, phoneNo, prisonAddress, criminalID});
                    }

                    prisonInfoTable.setModel(tableModel); // Set the table data

                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        topPanel.add(displayPrisonButton, BorderLayout.CENTER);

        contentPanel.add(topPanel, BorderLayout.NORTH);

        // Add your Prison_08 page content, such as buttons and other components
        // Add your Prison_08 page content here

        // Create a table to display prison information
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Prison ID");
        tableModel.addColumn("Prison Name");
        tableModel.addColumn("Phone No");
        tableModel.addColumn("Prison Address");
        tableModel.addColumn("Criminal ID");

        prisonInfoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(prisonInfoTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Footer label
        JLabel footerLabel = new JLabel("- Crime Management System - CS 608 -", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font and size
        contentPanel.add(footerLabel, BorderLayout.SOUTH);

        add(contentPanel);
	}

}
