package package1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class frame1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 window = new frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(172, 217, 106, 25);
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnCrimeRecordMane = new JTextPane();	
		txtpnCrimeRecordMane.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtpnCrimeRecordMane.setOpaque(false);// Set the background color to transparent
		txtpnCrimeRecordMane.setText("CS 608 - Crime Record Management System");
		txtpnCrimeRecordMane.setBounds(114, 245, 222, 21);
		frame.getContentPane().add(txtpnCrimeRecordMane);
	}

}
