/**
 * Created by: LINLAN CAI
 * Created on: 4:23:04 AM, Dec 14, 2023
 * File: LoginFrame.java
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */
public class LoginFrame extends JFrame {


	private JTextField usernameField;
    private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
	}
	/**
	 * Create the frame.
	 */
	public LoginFrame() {
        setTitle("CS 608 - LinlanCai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout()); // 使用GridBagLayout进行布局
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // 设置组件之间的间距
        
        // 在顶部添加一行字
        JLabel topLabel = new JLabel("- Crime Management System - CS 608 -", JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(topLabel, gbc);
        
        JLabel usernameLabel = new JLabel("username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passwordField, gbc);

        JButton loginButton = new JButton("LogIn");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // 跨两列，使按钮底部居中
        panel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
        	        @Override
        	        public void actionPerformed(ActionEvent e) {
        	            String username = usernameField.getText();
        	            String password = String.valueOf(passwordField.getPassword());
        	            String jdbcUrl = "jdbc:mysql://localhost:3306/Crime_Record_Management"; // 数据库URL
        	            String usernameSQL = "root"; // 数据库用户名
        	            String passwordSQL = "Pace1234@"; // 数据库密码
        	            
        	            Connection connection = null;

        	            try {
        	                connection = DriverManager.getConnection(jdbcUrl, usernameSQL, passwordSQL);
        	                if (connection != null) {
        	                    System.out.println("成功建立数据库连接！"
        	                    		+ "Connected successfully!");

        	                    // 执行数据库查询以检查用户名和密码
        	                    // 请根据数据库表格结构和查询逻辑进行更改
        	                    String query = "SELECT * FROM user_info WHERE username = ? AND password = ?";
        	                    PreparedStatement preparedStatement = connection.prepareStatement(query);
        	                    preparedStatement.setString(1, username);
        	                    preparedStatement.setString(2, password);
        	                    ResultSet resultSet = preparedStatement.executeQuery();

        	                    if (resultSet.next()) {
        	                        // 用户名和密码匹配，可以打开主界面
        	                        openMainFrame();
        	                    } else {
        	                        // 显示错误消息对话框
        	                        JOptionPane.showMessageDialog(LoginFrame.this, "Failed!!! Please Try Again", "Authentication Failed", JOptionPane.ERROR_MESSAGE);
        	                    }
        	                }
        	            } catch (SQLException ex) {
        	                System.err.println("数据库连接失败：" + ex.getMessage());
        	            } finally {
        	                if (connection != null) {
        	                    try {
        	                        connection.close();
        	                    } catch (SQLException ex) {
        	                        System.err.println("关闭数据库连接时出错：" + ex.getMessage());
        	                    }
        	                }
        	            }
        	        }

					private void openMainFrame() {
						// TODO Auto-generated method stub
						MainPageFrame mainPage = new MainPageFrame();
					    mainPage.setVisible(true); // 打开主页面
					    dispose(); // 关闭当前登录页面
					}
        	    });
        	    add(panel);
    }
}
