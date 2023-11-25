/**
 * Created by: LINLAN CAI
 * Created on: 3:29:50 PM, Nov 24, 2023
 * File: Frame3_court.java
 * 
 * Description: This file is subject to the terms and conditions of the MIT License.
 * See https://opensource.org/licenses/MIT for details.
 * Copyright (c) 2023 LINLAN CAI
 */
package package1;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * 
 */
public class Frame3_court extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCourtId;
    private JTextField textFieldCourtName;
    private JTextField textFieldCourtAddress;
    private JTextField textFieldCourtLevel;
    private JTable courtDataTable; // Table for displaying data
    
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
	                Frame3_court frame = new Frame3_court();
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
	public Frame3_court() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 400); // Adjust the window size
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        // Create a JPanel for the form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));
        

        // Add labels and text fields for court information
        JLabel lblCourtId = new JLabel("Court ID:");
        textFieldCourtId = new JTextField();
        JLabel lblCourtName = new JLabel("Court Name:");
        textFieldCourtName = new JTextField();
        JLabel lblCourtAddress = new JLabel("Court Address:");
        textFieldCourtAddress = new JTextField();
        JLabel lblCourtLevel = new JLabel("Court Level:");
        textFieldCourtLevel = new JTextField();

        // Add labels and text fields to the form panel
        formPanel.add(lblCourtId);
        formPanel.add(textFieldCourtId);
        formPanel.add(lblCourtName);
        formPanel.add(textFieldCourtName);
        formPanel.add(lblCourtAddress);
        formPanel.add(textFieldCourtAddress);
        formPanel.add(lblCourtLevel);
        formPanel.add(textFieldCourtLevel);

        // Button for actions (e.g., Save)
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(e -> {
            // Action to perform on save (e.g., insert/update data)
            String courtId = textFieldCourtId.getText();
            String courtName = textFieldCourtName.getText();
            String courtAddress = textFieldCourtAddress.getText();
            String courtLevel = textFieldCourtLevel.getText();
            saveCourtDataToSQLFile();
           
        });
        contentPane.add(btnSave);
        // Add other components and logic as necessary
     // Add the formPanel and btnSave to the contentPane
        contentPane.add(formPanel, BorderLayout.WEST);
        contentPane.add(btnSave, BorderLayout.SOUTH);

        // Create a JPanel for displaying data
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BorderLayout());

        // Create a DefaultTableModel for the table
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Court ID");
        tableModel.addColumn("Court Name");
        tableModel.addColumn("Court Address");
        tableModel.addColumn("Court Level");

        // Create the JTable with the DefaultTableModel
        courtDataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(courtDataTable);

        // Load data from the SQL file into the table
        loadCourtDataFromSQLFile(tableModel);

        // Add the table to the dataPanel
        dataPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the dataPanel to the contentPane
        contentPane.add(dataPanel, BorderLayout.CENTER);
    }
	/**
	 * 
	 */
	private void saveCourtDataToSQLFile() {
		// TODO Auto-generated method stub
		String courtId = textFieldCourtId.getText();
        String courtName = textFieldCourtName.getText();
        String courtAddress = textFieldCourtAddress.getText();
        String courtLevel = textFieldCourtLevel.getText();

        // Create a formatted string for the court record
        String courtRecord = String.format(
                "INSERT INTO court_info (court_id, court_name, court_address, court_level) " +
                        "VALUES ('%s', '%s', '%s', '%s');",
                courtId, courtName, courtAddress, courtLevel
        );

        // File path for the SQL file
        String filePath = "court_info.sql";

        try {
            // Open the file for writing (append mode)
            FileWriter fileWriter = new FileWriter(filePath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Write the formatted SQL statement to the file
            printWriter.println(courtRecord);

            // Close the file
            printWriter.close();

            // Inform the user that the data has been added to the file
            JOptionPane.showMessageDialog(null, "Court record added to " + filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
	}
	/**
	 * @param tableModel
	 */
	private void loadCourtDataFromSQLFile(DefaultTableModel tableModel) {
	    // JDBC connection parameters
	    String jdbcURL = "jdbc:mysql://your-database-host:your-database-port/your-database-name";
	    String jdbcUsername = "your-username";
	    String jdbcPassword = "your-password";

	    try {
	        // Create a database connection
	        Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

	        // Create and execute an SQL query to retrieve data from the Court_Info table
	        String sqlQuery = "SELECT * FROM Crime_Record_Management.Court_Info";
	        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Iterate through the result set and add data to the table model
	        while (resultSet.next()) {
	            String courtId = resultSet.getString("Court_id");
	            String courtName = resultSet.getString("Court_name");
	            String courtAddress = resultSet.getString("Court_address");
	            String courtLevel = resultSet.getString("Court_level");

	            // Create an array of row data
	            String[] rowData = { courtId, courtName, courtAddress, courtLevel };

	            // Add the row data to the table model
	            tableModel.addRow(rowData);
	        }

	        // Close the database resources
	        resultSet.close();
	        preparedStatement.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	    	}
	    }
	}

