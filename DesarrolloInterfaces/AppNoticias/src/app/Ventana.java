package app;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.PantallaCarga;

public class Ventana extends JFrame {

    private JPanel panelActual;

    public Ventana() {
        setTitle("App");
        setResizable(false);
        setBounds(100, 100, 800, 600);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/newsLogo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        mostrarPanel(new PantallaCarga());
    }

    public void mostrarPanel(JPanel nuevoPanel) {
    	
        panelActual = nuevoPanel;
        panelActual.setBounds(0, 0, 800, 600);
        getContentPane().add(panelActual);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
}
