
package Ventanas;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejemplo5 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo5 window = new Ejemplo5();
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
	public Ejemplo5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 500);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icono.png")));
		frame.getContentPane().add(buscarImagen());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private Component buscarImagen() {
		BufferedImage fondo = null;
		try {
			fondo = ImageIO.read(getClass().getResource("/fondo.jpeg"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		Image foto = fondo;
		JPanel panelConFondo = new JPanel() {
			private static final long serialversionUID = 1L;
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(foto, 0, 0, 850, 500, null);
			}
		};
		return panelConFondo;
	}

}
