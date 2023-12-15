/**
 * Created by: LINLAN CAI
 * Created on: 4:52:02 PM, Dec 14, 2023
 * File: CourtPage_01.java
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
import java.sql.DriverManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 */
public class CourtPage_01 extends JFrame {

	
	private JPanel contentPane;
	private JTable courtInfoTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourtPage_01 frame = new CourtPage_01();
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
	public CourtPage_01() {
		setTitle("Court Page - LinlanCai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);

        // 创建返回按钮
        JPanel contentPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());

        // Create Back button on the left
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainPageFrame mainPage = new MainPageFrame();
                mainPage.setVisible(true);
            }
        });

        // Create LogOut button on the right
        JButton logoutButton = new JButton("LogOut");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
        JButton refreshButton = new JButton("Display Court");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里添加刷新表格信息的代码
                displayCourtInfoTable(); // 调用刷新方法
            }

			private void displayCourtInfoTable() {
				// TODO Auto-generated method stub

				String jdbcUrl = "jdbc:mysql://localhost:3306/Crime_Record_Management"; // 数据库URL
	            String usernameSQL = "root"; // 数据库用户名
	            String passwordSQL = "Pace1234@"; // 数据库密码
	            
				try {
					Connection connection = DriverManager.getConnection(jdbcUrl,
							usernameSQL, passwordSQL);
					if (connection != null) {
					            System.out.println("成功建立数据库连接！"); // 连接成功时输出消息
					        }
					Statement statement = connection.createStatement();
					String query = "SELECT * FROM Court_Info";
					ResultSet resultSet = statement.executeQuery(query);

					DefaultTableModel tableModel = (DefaultTableModel) courtInfoTable
							.getModel();
					tableModel.setRowCount(0); // Clear existing rows

					while (resultSet.next()) {
						String courtID = resultSet.getString("Court_ID");
						String courtName = resultSet.getString("Court_Name");
						String courtAddress = resultSet
								.getString("Court_address");
						String courtLevel = resultSet.getString("Court_level");

						tableModel.addRow(new String[]{courtID, courtName,
								courtAddress, courtLevel});
					}

					tableModel.fireTableDataChanged(); // Notify the table to
														// refresh

					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException ex) {
				    ex.printStackTrace(); // 输出异常信息到控制台
				}
			}
				
			}
        
);
        topPanel.add(refreshButton, BorderLayout.CENTER);
        // Add Back button to the left
        
        topPanel.add(backButton, BorderLayout.WEST);
        // Add LogOut button to the right
        topPanel.add(logoutButton, BorderLayout.EAST);

        contentPanel.add(topPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        DefaultTableModel tableModel = new DefaultTableModel();
        courtInfoTable = new JTable(tableModel);
        tableModel.addColumn("Court ID");
        tableModel.addColumn("Court Name");
        tableModel.addColumn("Court Address"); // Add Court_address column
        tableModel.addColumn("Court Level");   // Add Court_level column

        scrollPane.setViewportView(courtInfoTable);

        // Add your CourtPage_01 page content here
        JButton courtButton = new JButton("Court");
		courtButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayCourtInfoTable();
			}

			// Display court information in the table
			private void displayCourtInfoTable() {
				String jdbcUrl = "jdbc:mysql://localhost:3306/Crime_Record_Management"; // 数据库URL
	            String usernameSQL = "root"; // 数据库用户名
	            String passwordSQL = "Pace1234@"; // 数据库密码
	            
				try {
					Connection connection = DriverManager.getConnection(jdbcUrl,
							usernameSQL, passwordSQL);
					if (connection != null) {
					            System.out.println("成功建立数据库连接！"); // 连接成功时输出消息
					        }
					Statement statement = connection.createStatement();
					String query = "SELECT * FROM Court_Info";
					ResultSet resultSet = statement.executeQuery(query);

					DefaultTableModel tableModel = (DefaultTableModel) courtInfoTable
							.getModel();
					tableModel.setRowCount(0); // Clear existing rows

					while (resultSet.next()) {
						String courtID = resultSet.getString("Court_ID");
						String courtName = resultSet.getString("Court_Name");
						String courtAddress = resultSet
								.getString("Court_address");
						String courtLevel = resultSet.getString("Court_level");

						tableModel.addRow(new String[]{courtID, courtName,
								courtAddress, courtLevel});
					}

					tableModel.fireTableDataChanged(); // Notify the table to
														// refresh

					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException ex) {
				    ex.printStackTrace(); // 输出异常信息到控制台
				}
			}
		});

        contentPanel.add(courtButton, BorderLayout.SOUTH);

        JLabel footerLabel = new JLabel("- Crime Management System - CS 608 -", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(footerLabel, BorderLayout.SOUTH);

        add(contentPanel);
    }
}