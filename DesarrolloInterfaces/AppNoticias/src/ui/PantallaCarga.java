package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import app.Ventana;

import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class PantallaCarga extends JPanel {
	
	JProgressBar progressBar;
	JLabel cargando;
	Timer tiempo;
	int i = 0;
	private Ventana ventanaPrincipal;

	public PantallaCarga(Ventana ventanaPrincipal) { 
        this.ventanaPrincipal = ventanaPrincipal;
        
		//setBackground(SystemColor.white);
		setLayout(null);
		
		progressBar = new JProgressBar(0, 100);
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setStringPainted(true);
		progressBar.setToolTipText("");
		progressBar.setVisible(true);
		progressBar.setForeground(new Color(30, 144, 255));

		progressBar.setBounds(-2, 530, 800, 35);
		add(progressBar);
		
		cargando = new JLabel("Cargando...");
        cargando.setForeground(new Color(30, 144, 255));
        cargando.setBounds(370, 500, 200, 25);
        add(cargando);
		/*ImageIcon gif = new ImageIcon(getClass().getResource("/ImagenesGifs/gif1.png"));
		Image img = gif.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		gif = new ImageIcon(img);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(290, 331, 227, 163);
		lblNewLabel.setIcon(gif);
		add(lblNewLabel);*/
		
		JPanel fondo = (JPanel) buscarImagen();
		fondo.setLayout(null);
		fondo.setBounds(0,0,800,600);
		add(fondo);
		
		tiempo = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				i++;
				progressBar.setValue(i);
				progressBar.setString(i+"%");
					
				if (i >= 100) {
					tiempo.stop();
					ventanaPrincipal.mostrarInicio();
		                
				}
			}
		});
		
		tiempo.start();


	}
	
	private Component buscarImagen() {
		BufferedImage fondo = null;
		try {
			fondo = ImageIO.read(getClass().getResource("/ImagenesGifs/fondo12.jpg"));
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
				g.drawImage(foto, 0, 0, 800, 600, null);
			}
		};
		return panelConFondo;
	}
}
