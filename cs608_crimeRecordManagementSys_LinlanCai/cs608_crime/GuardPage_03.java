/**
 * Created by: LINLAN CAI
 * Created on: 5:05:48 PM, Dec 14, 2023
 * File: GuardPage_03.java
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
/**
 * 
 */
public class GuardPage_03 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable guardInfoTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GuardPage_03 frame = new GuardPage_03();
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
	public GuardPage_03() {
		setTitle("Guard Page - LinlanCai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new BorderLayout());

        // 创建顶部面板
        JPanel topPanel = new JPanel(new BorderLayout());

        // 创建返回按钮
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
        logoutButton.setPreferredSize(new Dimension(100, 30)); // 调整按钮大小
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
        topPanel.add(logoutButton, BorderLayout.EAST);

        JButton displayButton = new JButton("Display Guards");
        displayButton.setPreferredSize(new Dimension(150, 30)); // 调整按钮大小
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayGuardInfoTable();
            }

            private void displayGuardInfoTable() {
                String jdbcUrl = "jdbc:mysql://localhost:3306/Crime_Record_Management";
                String usernameSQL = "root";
                String passwordSQL = "Pace1234@";

                try {
                    Connection connection = DriverManager.getConnection(jdbcUrl, usernameSQL, passwordSQL);
                    if (connection != null) {
                        System.out.println("Successfully established database connection!");
                    }

                    Statement statement = connection.createStatement();
                    String query = "SELECT * FROM Guard_Info";
                    ResultSet resultSet = statement.executeQuery(query);

                    DefaultTableModel tableModel = new DefaultTableModel();
                    tableModel.addColumn("Guard ID");
                    tableModel.addColumn("First Name");
                    tableModel.addColumn("Last Name");
                    tableModel.addColumn("Gender");
                    tableModel.addColumn("DOB");
                    tableModel.addColumn("Age");
                    tableModel.addColumn("Address");
                    tableModel.addColumn("Phone No");
                    tableModel.addColumn("Alternate Phone No");
                    tableModel.addColumn("Shift Timing");
                    tableModel.addColumn("Position");

                    while (resultSet.next()) {
                        String guardID = resultSet.getString("Guard_id");
                        String firstName = resultSet.getString("First_name");
                        String lastName = resultSet.getString("Last_name");
                        String gender = resultSet.getString("Gender");
                        String dob = resultSet.getString("DOB");
                        int age = resultSet.getInt("Age");
                        String address = resultSet.getString("Address");
                        String phoneNo = resultSet.getString("Phone_no");
                        String alternatePhoneNo = resultSet.getString("Alternate_phone_no");
                        String shiftTiming = resultSet.getString("Shift_timing");
                        String position = resultSet.getString("Position");

                        tableModel.addRow(new String[]{guardID, firstName, lastName, gender, dob, String.valueOf(age), address, phoneNo, alternatePhoneNo, shiftTiming, position});
                    }

                    guardInfoTable.setModel(tableModel); // 设置表格数据

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

        // 创建表格
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Guard ID");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Gender");
        tableModel.addColumn("DOB");
        tableModel.addColumn("Age");
        tableModel.addColumn("Address");
        tableModel.addColumn("Phone No");
        tableModel.addColumn("Alternate Phone No");
        tableModel.addColumn("Shift Timing");
        tableModel.addColumn("Position");

        guardInfoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(guardInfoTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // 创建底部标签
        JLabel footerLabel = new JLabel("- Crime Management System - CS 608 -", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(footerLabel, BorderLayout.SOUTH);

        add(contentPanel);
	}

}
