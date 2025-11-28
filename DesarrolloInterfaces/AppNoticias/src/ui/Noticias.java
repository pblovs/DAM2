package ui;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import model.Preferencia;
import model.Usuario;

public class Noticias extends JPanel{
	
	Usuario user = InicioSesion.user;
	public Noticias() {
		setBackground(new Color(30, 144, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOTICIAS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(279, 46, 211, 22);
		add(lblNewLabel);
		
		JLabel dep = new JLabel("Deporte");
		dep.setVisible(false);
		dep.setBounds(88, 148, 46, 14);
		add(dep);
		
		JLabel pol = new JLabel("Politica");
		pol.setVisible(false);
		pol.setBounds(207, 148, 46, 14);
		add(pol);
		
		JLabel cul = new JLabel("Cultura");
		cul.setVisible(false);
		cul.setBounds(322, 148, 46, 14);
		add(cul);
		
		JLabel nac = new JLabel("Nacional");
		nac.setVisible(false);
		nac.setBounds(436, 148, 46, 14);
		add(nac);
		
		JLabel inter = new JLabel("Internacional");
		inter.setVisible(false);
		inter.setBounds(564, 148, 85, 14);
		add(inter);
		
		for (Preferencia p : user.getPrefs()) {
			if(p.getTipo().equals("D")) {
				dep.setVisible(true);
			}
			if(p.getTipo().equals("P")) {
				pol.setVisible(true);
			}
			if(p.getTipo().equals("C")) {
				cul.setVisible(true);
			}
			if(p.getTipo().equals("N")) {
				nac.setVisible(true);
			}
			if(p.getTipo().equals("I")) {
				inter.setVisible(true);
			}
		}
	}
}
