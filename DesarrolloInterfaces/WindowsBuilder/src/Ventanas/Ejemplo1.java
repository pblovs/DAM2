package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import java.awt.Color;

public class Ejemplo1 {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo1 window = new Ejemplo1();
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
	public Ejemplo1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 192));
		frame.setBounds(100, 100, 667, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("apretá");
		btnNewButton.setToolTipText("mamahuevo");
		btnNewButton.setBounds(216, 175, 196, 54);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ayiyiyi");
		lblNewLabel.setBounds(216, 147, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(272, 144, 140, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("SI");
		rdbtnNewRadioButton.setBounds(216, 266, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("NO");
		rdbtnNewRadioButton_1.setBounds(216, 292, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("¿HUELGA?");
		lblNewLabel_1.setBounds(216, 245, 76, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox(" burro");
		chckbxNewCheckBox.setBounds(432, 143, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(216, 337, 196, 20);
		frame.getContentPane().add(passwordField);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(272, 113, 53, 20);
		frame.getContentPane().add(spinner);
	}
}
