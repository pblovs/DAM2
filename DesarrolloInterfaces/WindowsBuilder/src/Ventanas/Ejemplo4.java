package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;
import javax.swing.JComboBox;

public class Ejemplo4 {

	private JFrame frame;
	private JPanel panel_1; //azul
	private JPanel panel_2; //naranja
	private JPanel panel; //verde
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo4 window = new Ejemplo4();
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
	public Ejemplo4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(layeredPane);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 140, 0));
		panel_2.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("AZUL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(false);
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VERDE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(false);
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(335, 11, 89, 23);
		panel_2.add(btnNewButton_1);
		
		

		

		
		panel = new JPanel();
		panel.setBackground(new Color(154, 205, 50));
		panel.setBounds(0, 0, 434, 261);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton_2 = new JButton("NARANJA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(335, 11, 89, 23);
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("AZUL");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(false);
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(10, 11, 89, 23);
		panel.add(btnNewButton_3);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton_4 = new JButton("NARANJA");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(335, 11, 89, 23);
		panel_1.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("VERDE");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(false);
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(10, 11, 89, 23);
		panel_1.add(btnNewButton_5);
	}
}
