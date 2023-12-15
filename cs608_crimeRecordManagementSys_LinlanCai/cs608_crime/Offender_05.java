/**
 * Created by: LINLAN CAI
 * Created on: 5:11:22 PM, Dec 14, 2023
 * File: Offender_05.java
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 */
public class Offender_05 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable offenderInfoTable;
	
    private JTextField criminalIDField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField genderField;
    private JTextField ageField;
    private JTextField nationalityField;
    private JTextField addressField;
    private JTextField phoneNoField;
    private JTextField alternatePhoneNoField;
    private JTextField offenseTypeField;
    private JTextField bailStatusField;
    private JTextField jailTermsField;
    private JTextField prisonLocationField;
    private JTextField prisonGuardField;
    private JTextField victimIDField;
    private JTextField judgeIDField;
    private JTextField courtIDField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Offender_05 frame = new Offender_05();
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
	public Offender_05() {
		setTitle("Offender Page - LinlanCai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new BorderLayout());

        // Create the top panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Create the Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainPageFrame mainPage = new MainPageFrame();
                mainPage.setVisible(true);
            }
        });
        topPanel.add(backButton);

        // Create the Log Out button
        JButton logoutButton = new JButton("LogOut");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
        topPanel.add(logoutButton);

        // Create the Add button
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOffenderToDatabase();
            }

            private void addOffenderToDatabase() {
                String jdbcUrl = "jdbc:mysql://localhost:3306/Crime_Record_Management";
                String usernameSQL = "root";
                String passwordSQL = "Pace1234@";

                String criminalID = criminalIDField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String gender = genderField.getText();
                String age = ageField.getText();
                String nationality = nationalityField.getText();
                String address = addressField.getText();
                String phoneNo = phoneNoField.getText();
                String alternatePhoneNo = alternatePhoneNoField.getText();
                String offenseType = offenseTypeField.getText();
                String bailStatus = bailStatusField.getText();
                String jailTerms = jailTermsField.getText();
                String prisonLocation = prisonLocationField.getText();
                String prisonGuard = prisonGuardField.getText();
                String victimID = victimIDField.getText();
                String judgeID = judgeIDField.getText();
                String courtID = courtIDField.getText();

                try {
                    Connection connection = DriverManager.getConnection(jdbcUrl, usernameSQL, passwordSQL);
                    if (connection != null) {
                        System.out.println("Database connection successful!");
                    }
                    String insertQuery = "INSERT INTO Offender_Info (Criminal_id, First_name, Last_name, " +
                            "Gender, Age, Nationality, Address, Phone_no, Alternate_phone_no, Offense_type, " +
                            "Bail_status, Jail_terms, Prison_location, Prison_guard, Victim_id, Judge_id, " +
                            "Court_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                    preparedStatement.setString(1, criminalID);
                    preparedStatement.setString(2, firstName);
                    preparedStatement.setString(3, lastName);
                    preparedStatement.setString(4, gender);
                    preparedStatement.setString(5, age);
                    preparedStatement.setString(6, nationality);
                    preparedStatement.setString(7, address);
                    preparedStatement.setString(8, phoneNo);
                    preparedStatement.setString(9, alternatePhoneNo);
                    preparedStatement.setString(10, offenseType);
                    preparedStatement.setString(11, bailStatus);
                    preparedStatement.setString(12, jailTerms);
                    preparedStatement.setString(13, prisonLocation);
                    preparedStatement.setString(14, prisonGuard);
                    preparedStatement.setString(15, victimID);
                    preparedStatement.setString(16, judgeID);
                    preparedStatement.setString(17, courtID);

                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        topPanel.add(addButton);

        // Create the Display Offender button
        JButton displayOffenderButton = new JButton("Display Offender");
        displayOffenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayOffenderInfoTable();
            }

			private void displayOffenderInfoTable() {
				// Configure your database connection parameters
				String jdbcUrl = "jdbc:mysql://localhost:3306/Crime_Record_Management";
				String usernameSQL = "root";
				String passwordSQL = "Pace1234@";

				try {
					Connection connection = DriverManager.getConnection(jdbcUrl,
							usernameSQL, passwordSQL);
					if (connection != null) {
						System.out.println("Database connection successful!");
					}

					Statement statement = connection.createStatement();
					String query = "SELECT * FROM Offender_Info"; // Customize
																	// your SQL
																	// query
					ResultSet resultSet = statement.executeQuery(query);

					DefaultTableModel tableModel = new DefaultTableModel();
					tableModel.addColumn("Criminal ID");
					tableModel.addColumn("First Name");
					tableModel.addColumn("Last Name");
					tableModel.addColumn("Gender");
					tableModel.addColumn("Age");
					tableModel.addColumn("Nationality");
					tableModel.addColumn("Address");
					tableModel.addColumn("Phone No");
					tableModel.addColumn("Offense Type");
					tableModel.addColumn("Bail Status");
					tableModel.addColumn("Jail Terms");
					tableModel.addColumn("Prison Location");
					tableModel.addColumn("Prison Guard");
					tableModel.addColumn("Victim ID");
					tableModel.addColumn("Judge ID");
					tableModel.addColumn("Court ID");

					while (resultSet.next()) {
						String criminalID = resultSet.getString("Criminal_id");
						String firstName = resultSet.getString("First_name");
						String lastName = resultSet.getString("Last_name");
						String gender = resultSet.getString("Gender");
						String age = resultSet.getString("Age");
						String nationality = resultSet.getString("Nationality");
						String address = resultSet.getString("Address");
						String phoneNo = resultSet.getString("Phone_no");
						String offenseType = resultSet
								.getString("Offense_type");
						String bailStatus = resultSet.getString("Bail_status");
						String jailTerms = resultSet.getString("Jail_terms");
						String prisonLocation = resultSet
								.getString("Prison_location");
						String prisonGuard = resultSet
								.getString("Prison_guard");
						String victimID = resultSet.getString("Victim_id");
						String judgeID = resultSet.getString("Judge_id");
						String courtID = resultSet.getString("Court_id");

						tableModel.addRow(new String[]{criminalID, firstName,
								lastName, gender, age, nationality, address,
								phoneNo, offenseType, bailStatus, jailTerms,
								prisonLocation, prisonGuard, victimID, judgeID,
								courtID});
					}

					offenderInfoTable.setModel(tableModel); // Set the table
															// data

					resultSet.close();
					statement.close();
					connection.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
        });
        topPanel.add(displayOffenderButton);

        contentPanel.add(topPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputPanel.add(new JLabel("Criminal ID:"));
        criminalIDField = new JTextField();
        inputPanel.add(criminalIDField);

        inputPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        inputPanel.add(firstNameField);

        inputPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        inputPanel.add(lastNameField);

        // Add more fields here as needed
        inputPanel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        inputPanel.add(genderField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Nationality:"));
        nationalityField = new JTextField();
        inputPanel.add(nationalityField);

        inputPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        inputPanel.add(addressField);

        inputPanel.add(new JLabel("Phone No:"));
        phoneNoField = new JTextField();
        inputPanel.add(phoneNoField);

        inputPanel.add(new JLabel("Alternate Phone No:"));
        alternatePhoneNoField = new JTextField();
        inputPanel.add(alternatePhoneNoField);

        inputPanel.add(new JLabel("Offense Type:"));
        offenseTypeField = new JTextField();
        inputPanel.add(offenseTypeField);

        inputPanel.add(new JLabel("Bail Status:"));
        bailStatusField = new JTextField();
        inputPanel.add(bailStatusField);

        inputPanel.add(new JLabel("Jail Terms:"));
        jailTermsField = new JTextField();
        inputPanel.add(jailTermsField);

        inputPanel.add(new JLabel("Prison Location:"));
        prisonLocationField = new JTextField();
        inputPanel.add(prisonLocationField);

        inputPanel.add(new JLabel("Prison Guard:"));
        prisonGuardField = new JTextField();
        inputPanel.add(prisonGuardField);

        inputPanel.add(new JLabel("Victim ID:"));
        victimIDField = new JTextField();
        inputPanel.add(victimIDField);

        inputPanel.add(new JLabel("Judge ID:"));
        judgeIDField = new JTextField();
        inputPanel.add(judgeIDField);

        inputPanel.add(new JLabel("Court ID:"));
        courtIDField = new JTextField();
        inputPanel.add(courtIDField);

        contentPanel.add(inputPanel, BorderLayout.WEST);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Criminal ID");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Age");
        tableModel.addColumn("Nationality");
        tableModel.addColumn("Address");
        tableModel.addColumn("Phone No");
        tableModel.addColumn("Alternate Phone No");
        tableModel.addColumn("Offense Type");
        tableModel.addColumn("Bail Status");
        tableModel.addColumn("Jail Terms");
        tableModel.addColumn("Prison Location");
        tableModel.addColumn("Prison Guard");
        tableModel.addColumn("Victim ID");
        tableModel.addColumn("Judge ID");
        tableModel.addColumn("Court ID");

        offenderInfoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(offenderInfoTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        JLabel footerLabel = new JLabel("- Crime Management System - CS 608 -", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(footerLabel, BorderLayout.SOUTH);

        add(contentPanel);
    }
}