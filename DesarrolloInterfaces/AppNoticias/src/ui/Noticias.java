package ui;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Noticias extends JPanel{
	public Noticias() {
		setBackground(new Color(30, 144, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOTICIAS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(279, 46, 211, 22);
		add(lblNewLabel);
	}
}
