/**
 * Created by: LINLAN CAI
 * Created on: 5:13:27 PM, Dec 14, 2023
 * File: Punishment_06.java
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
public class Punishment_06 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable punishmentInfoTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Punishment_06 frame = new Punishment_06();
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
	public Punishment_06() {
		setTitle("Punishment Page - LinlanCai");
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

        // Create Display Punishment button
        JButton displayPunishmentButton = new JButton("Display Punishment");
        displayPunishmentButton.setPreferredSize(new Dimension(150, 30)); // Set button size
        displayPunishmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display punishment information in a table
                displayPunishmentInfoTable();
            }

            private void displayPunishmentInfoTable() {
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
                    String query = "SELECT * FROM Punishment_Info"; // Customize your SQL query
                    ResultSet resultSet = statement.executeQuery(query);

                    DefaultTableModel tableModel = new DefaultTableModel();
                    tableModel.addColumn("Punishment ID");
                    tableModel.addColumn("From Date");
                    tableModel.addColumn("From Time");
                    tableModel.addColumn("To Date");
                    tableModel.addColumn("To Time");
                    tableModel.addColumn("Total Duration");
                    tableModel.addColumn("Type of Punishment");
                    tableModel.addColumn("Punishment Description");
                    tableModel.addColumn("Punishment Inc");
                    tableModel.addColumn("Reason for Punishment Inc");
                    tableModel.addColumn("Criminal ID");
                    tableModel.addColumn("Prison ID");
                    tableModel.addColumn("Judge ID");
                    tableModel.addColumn("Crime ID");

                    while (resultSet.next()) {
                        String punishmentID = resultSet.getString("punishment_id");
                        String fromDate = resultSet.getString("From_date");
                        String fromTime = resultSet.getString("From_time");
                        String toDate = resultSet.getString("To_date");
                        String toTime = resultSet.getString("To_time");
                        String totalDuration = resultSet.getString("Total_duration");
                        String typeOfPunishment = resultSet.getString("Type_punishment");
                        String punishmentDescription = resultSet.getString("Punishment_des");
                        String punishmentInc = resultSet.getString("Punishment_inc");
                        String reasonForPunishmentInc = resultSet.getString("Reason_punishment_inc");
                        String criminalID = resultSet.getString("Criminal_id");
                        String prisonID = resultSet.getString("Prison_id");
                        String judgeID = resultSet.getString("Judge_id");
                        String crimeID = resultSet.getString("Crime_id");

                        tableModel.addRow(new String[]{punishmentID, fromDate, fromTime, toDate, toTime, totalDuration, typeOfPunishment, punishmentDescription, punishmentInc, reasonForPunishmentInc, criminalID, prisonID, judgeID, crimeID});
                    }

                    punishmentInfoTable.setModel(tableModel); // Set the table data

                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        topPanel.add(displayPunishmentButton, BorderLayout.CENTER);

        contentPanel.add(topPanel, BorderLayout.NORTH);

        // Add your Punishment_06 page content, such as buttons and other components
        // Add your Punishment_06 page content here

        // Create a table to display punishment information
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Punishment ID");
        tableModel.addColumn("From Date");
        tableModel.addColumn("From Time");
        tableModel.addColumn("To Date");
        tableModel.addColumn("To Time");
        tableModel.addColumn("Total Duration");
        tableModel.addColumn("Type of Punishment");
        tableModel.addColumn("Punishment Description");
        tableModel.addColumn("Punishment Inc");
        tableModel.addColumn("Reason for Punishment Inc");
        tableModel.addColumn("Criminal ID");
        tableModel.addColumn("Prison ID");
        tableModel.addColumn("Judge ID");
        tableModel.addColumn("Crime ID");

        punishmentInfoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(punishmentInfoTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Footer label
        JLabel footerLabel = new JLabel("- Crime Management System - CS 608 -", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font and size
        contentPanel.add(footerLabel, BorderLayout.SOUTH);

        add(contentPanel);
	}

}
