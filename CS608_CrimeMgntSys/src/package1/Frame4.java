/**
 * Created by: LINLAN CAI
 * Created on: 3:33:13 PM, Nov 24, 2023
 * File: Frame4.java
 * 
 * Description: This file is subject to the terms and conditions of the MIT License.
 * See https://opensource.org/licenses/MIT for details.
 * Copyright (c) 2023 LINLAN CAI
 */
package package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
public class Frame4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
					Frame4 frame = new Frame4();
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
	public Frame4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
