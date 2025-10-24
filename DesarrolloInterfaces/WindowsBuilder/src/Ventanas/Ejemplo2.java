package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo2 {

	private JFrame frame;
	private JTextField textField;
	private int contador = 0;
	private JPanel panel_1;
	private JPanel panel_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo2 window = new Ejemplo2();
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
	public Ejemplo2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		frame.getContentPane().add(panel, "name_12193318636300");
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("CLICK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador++;
				textField.setText(Integer.toString(contador));
			}
		});
		btnNewButton.setBounds(175, 126, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("NÚMERO DE CLICKS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(146, 72, 144, 30);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(175, 178, 89, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(375, 227, 49, 23);
		panel.add(btnNewButton_1);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		frame.getContentPane().add(panel_1, "name_12198764597900");
		panel_1.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("<");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1.setBounds(10, 227, 47, 23);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton(">");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_2.setBounds(377, 228, 47, 23);
		panel_1.add(btnNewButton_1_2);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(true);

			}
		});
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 128));
		frame.getContentPane().add(panel_2, "name_12201843456100");
		panel_2.setLayout(null);
		
		JButton btnNewButton_1_1_1 = new JButton("<");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setBounds(10, 227, 47, 23);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(btnNewButton_1_1_1);
	}
}
