package app;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Usuario;
import ui.Configuracion;
import ui.InicioSesion;
import ui.Noticias;
import ui.PantallaCarga;

public class Ventana extends JFrame {

	private JLayeredPane layeredPane;
	private JPanel panelCarga;
	private JPanel inicio;
	private JPanel config;
	private JPanel noticias;

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
        inicio = new InicioSesion(this);
        
        panelCarga.setBounds(0, 0, 800, 600);
        inicio.setBounds(0, 0, 800, 600);

        
        layeredPane.add(panelCarga);
        layeredPane.add(inicio);

        
        panelCarga.setVisible(true);
        inicio.setVisible(false);
       

        
    }

    public void mostrarInicio() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	if (noticias!= null) { //esto es pq al cerrar sesion el panel de notocias se queda igual y hay que crearlo de nuevo
    		layeredPane.remove(noticias); 
    	}
        panelCarga.setVisible(false);
        inicio.setVisible(true);
    }
    
    public void mostrarConfig(Usuario user) {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
        config = new Configuracion(this, user);
        config.setBounds(0, 0, 800, 600);
        layeredPane.add(config);

        inicio.setVisible(false);
        config.setVisible(true);

    }
    
    public void mostrarNoticias(Usuario user) {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
        noticias = new Noticias(this, user);
        noticias.setBounds(0, 0, 800, 600);
        layeredPane.add(noticias);
        
        if (config!=null) {
        	config.setVisible(false);
        }
        
        inicio.setVisible(false);
        noticias.setVisible(true);
    }
}
