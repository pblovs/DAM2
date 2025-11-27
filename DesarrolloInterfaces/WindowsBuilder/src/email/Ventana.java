package email;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	
	Panel panelEmail;
	
	public Ventana() {
		
		setTitle("Enviar email");
        setResizable(false);
        setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        panelEmail = new Panel(); 
        panelEmail.setBounds(0, 0, 800, 600);
        panelEmail.setVisible(true);
        add(panelEmail);

	}
}
