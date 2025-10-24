package Ventanas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Ejemplo3 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo3 window = new Ejemplo3();
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
	public Ejemplo3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize();
		int resolucion_y = (int) monitor.getHeight();
		int resolucion_x = (int) monitor.getWidth();
		frame = new JFrame();
		frame.setBounds(100, 100, 596, 430);
		frame.setLocation((resolucion_x/2) - (frame.getWidth()/2), (resolucion_y/2) - (frame.getHeight()/2));
		//frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
