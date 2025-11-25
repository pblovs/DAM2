package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import app.Ventana;

import java.awt.SystemColor;

public class PantallaCarga extends JPanel {
	
	JProgressBar progressBar;
	JLabel cargando;
	Timer tiempo;
	int i = 0;
	private Ventana ventanaPrincipal;

	public PantallaCarga(Ventana ventanaPrincipal) { 
        this.ventanaPrincipal = ventanaPrincipal;
        
		setBackground(SystemColor.white);
		setVisible(true);
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
}
