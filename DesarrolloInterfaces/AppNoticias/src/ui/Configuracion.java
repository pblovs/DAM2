package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Configuracion extends JPanel{
	
	public Configuracion(){
		setBackground(new Color(30, 144, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONFIGURACIÓN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(220, 28, 334, 50);
		add(lblNewLabel);
		
	}
}
