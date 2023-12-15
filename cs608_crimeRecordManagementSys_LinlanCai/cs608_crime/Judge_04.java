/**
 * Created by: LINLAN CAI
 * Created on: 5:08:41 PM, Dec 14, 2023
 * File: Judge_04.java
 * 
 * Description: This file is subject to the terms and conditions of the MIT License.
 * See https://opensource.org/licenses/MIT for details.
 * Copyright (c) 2023 LINLAN CAI
 */
package cs608_crime;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 */
public class Judge_04 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable judgeInfoTable;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Judge_04 frame = new Judge_04();
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
    public Judge_04() {
        setTitle("Judge Page - LinlanCai");
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

        // Create the Display button
        JButton displayButton = new JButton("Display Judges");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayJudgeInfoTable();
            }

            private void displayJudgeInfoTable() {
                String jdbcUrl = "jdbc:mysql://localhost:3306/Crime_Record_Management";
                String usernameSQL = "root";
                String passwordSQL = "Pace1234@";

                try {
                    Connection connection = DriverManager.getConnection(jdbcUrl, usernameSQL, passwordSQL);
                    if (connection != null) {
                        System.out.println("Successfully connected to the database!");
                    }

                    Statement statement = connection.createStatement();
                    String query = "SELECT * FROM Judge_Info";
                    ResultSet resultSet = statement.executeQuery(query);

                    DefaultTableModel tableModel = new DefaultTableModel();
                    tableModel.addColumn("Judge ID");
                    tableModel.addColumn("Judge Age");
                    tableModel.addColumn("First Name");
                    tableModel.addColumn("Last Name");
                    tableModel.addColumn("Designation");
                    tableModel.addColumn("Court ID");

                    while (resultSet.next()) {
                        String judgeID = resultSet.getString("Judge_id");
                        int judgeAge = resultSet.getInt("Judge_age");
                        String firstName = resultSet.getString("First_name");
                        String lastName = resultSet.getString("Last_name");
                        String designation = resultSet.getString("Designation");
                        String courtID = resultSet.getString("Court_id");

                        tableModel.addRow(new Object[]{judgeID, judgeAge, firstName, lastName, designation, courtID});
                    }

                    judgeInfoTable.setModel(tableModel); // Set table data

                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        topPanel.add(displayButton, BorderLayout.CENTER);

        contentPanel.add(topPanel, BorderLayout.NORTH);

        // Add your Judge_04 page content, such as buttons and other components
        // Add your Judge_04 page content here

        // Footer label
        JLabel footerLabel = new JLabel("- Crime Management System - CS 608 -", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font and size
        contentPanel.add(footerLabel, BorderLayout.SOUTH);

        // Create a table
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Judge ID");
        tableModel.addColumn("Judge Age");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Designation");
        tableModel.addColumn("Court ID");

        judgeInfoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(judgeInfoTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        add(contentPanel);
    }
}