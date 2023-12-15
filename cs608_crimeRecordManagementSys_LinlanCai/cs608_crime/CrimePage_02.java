/**
 * Created by: LINLAN CAI
 * Created on: 4:59:25 PM, Dec 14, 2023
 * File: CrimePage_02.java
 * 
 * Description: This file is subject to the terms and conditions of the MIT License.
 * See https://opensource.org/licenses/MIT for details.
 * Copyright (c) 2023 LINLAN CAI
 */
package cs608_crime;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class CrimePage_02 extends JFrame {

    private JPanel contentPane;
    private JTable crimeInfoTable;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CrimePage_02 frame = new CrimePage_02();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CrimePage_02() {
        setTitle("Crime Page - LinlanCai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 30)); // 调整按钮大小
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainPageFrame mainPage = new MainPageFrame();
                mainPage.setVisible(true);
            }
        });
        topPanel.add(backButton, BorderLayout.WEST);

        JButton logoutButton = new JButton("LogOut");
        logoutButton.setPreferredSize(new Dimension(100, 30));
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });

        topPanel.add(logoutButton, BorderLayout.EAST);
        
        JButton displayButton = new JButton("Display Crime");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayCrimeInfoTable();
            }

            private void displayCrimeInfoTable() {
                String jdbcUrl = "jdbc:mysql://localhost:3306/Crime_Record_Management";
                String usernameSQL = "root";
                String passwordSQL = "Pace1234@";

                try {
                    Connection connection = DriverManager.getConnection(jdbcUrl, usernameSQL, passwordSQL);
                    if (connection != null) {
                        System.out.println("Successfully established database connection!");
                    }

                    Statement statement = connection.createStatement();
                    String query = "SELECT * FROM Crime_Info";
                    ResultSet resultSet = statement.executeQuery(query);

                    DefaultTableModel tableModel = new DefaultTableModel();
                    tableModel.addColumn("Crime ID");
                    tableModel.addColumn("Crime Type");
                    tableModel.addColumn("Weapon Used");
                    tableModel.addColumn("Crime Date");
                    tableModel.addColumn("Crime Time");
                    tableModel.addColumn("Crime Location");
                    tableModel.addColumn("Criminal ID");
                    tableModel.addColumn("Victim ID");
                    tableModel.addColumn("Crime Description");

                    while (resultSet.next()) {
                        String crimeID = resultSet.getString("Crime_id");
                        String crimeType = resultSet.getString("Crime_type");
                        String weaponUsed = resultSet.getString("Weapon_used");
                        String crimeDate = resultSet.getString("Crime_date");
                        String crimeTime = resultSet.getString("Crime_time");
                        String crimeLocation = resultSet.getString("Crime_location");
                        String criminalID = resultSet.getString("Criminal_id");
                        String victimID = resultSet.getString("Victim_id");
                        String crimeDescription = resultSet.getString("Crime_description");

                        tableModel.addRow(new String[]{crimeID, crimeType, weaponUsed, crimeDate, crimeTime, crimeLocation, criminalID, victimID, crimeDescription});
                    }

                    crimeInfoTable.setModel(tableModel); // 设置表格数据

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

        JButton crimeButton = new JButton("Crime");
        crimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在此处添加跳转到Crime_info页面的代码
            }
        });
        contentPanel.add(crimeButton, BorderLayout.CENTER);

        JLabel footerLabel = new JLabel("- Crime Management System - CS 608 -", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(footerLabel, BorderLayout.SOUTH);

        // 创建表格
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Crime ID");
        tableModel.addColumn("Crime Type");
        tableModel.addColumn("Weapon Used");
        tableModel.addColumn("Crime Date");
        tableModel.addColumn("Crime Time");
        tableModel.addColumn("Crime Location");
        tableModel.addColumn("Criminal ID");
        tableModel.addColumn("Victim ID");
        tableModel.addColumn("Crime Description");

        crimeInfoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(crimeInfoTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        add(contentPanel);
    }
}
