package app;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import ui.InicioSesion;
import ui.PantallaCarga;

public class Ventana extends JFrame {

	private JLayeredPane layeredPane;
	private JPanel panelCarga;
	private JPanel inicio;

    public Ventana() {
        setTitle("App");
        setResizable(false);
        setBounds(100, 100, 800, 600);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/newsLogo.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);        
		setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 600);
        getContentPane().add(layeredPane);
        
        panelCarga = new PantallaCarga(this); 
        inicio = new InicioSesion();
        
        panelCarga.setBounds(0, 0, 800, 600);
        inicio.setBounds(0, 0, 800, 600);
        
        layeredPane.add(panelCarga);
        layeredPane.add(inicio);
        
        panelCarga.setVisible(true);
        inicio.setVisible(false);
        
    }

    public void mostrarInicio() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelCarga.setVisible(false);
        inicio.setVisible(true);
    }
}
