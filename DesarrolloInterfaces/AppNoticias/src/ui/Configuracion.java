package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import app.Ventana;
import model.Usuario;
import read_write.GuardarPreferencias;

import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Cursor;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Configuracion extends JPanel{
	
	private Ventana ventanaPrincipal;
	private Usuario user;

	
	public Configuracion(Ventana ventanaPrincipal, Usuario user){
        this.ventanaPrincipal = ventanaPrincipal;
        this.user = user;

		setBackground(new Color(30, 144, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONFIGURACIÓN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(220, 28, 334, 50);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Preferencias");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(74, 152, 209, 21);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("___________________________________________________________________________________________");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(74, 173, 684, 14);
		add(lblNewLabel_2);
		
		JCheckBox deportes = new JCheckBox("Deportes");
		deportes.setAlignmentY(Component.TOP_ALIGNMENT);
		deportes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deportes.setFont(new Font("Tahoma", Font.BOLD, 11));
		deportes.setForeground(new Color(255, 255, 255));
		deportes.setBackground(new Color(30, 144, 255));
		deportes.setBounds(81, 223, 97, 23);
		add(deportes);
		
		JCheckBox politica = new JCheckBox("Política");
		politica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		politica.setFont(new Font("Tahoma", Font.BOLD, 11));
		politica.setForeground(new Color(255, 255, 255));
		politica.setBackground(new Color(30, 144, 255));
		politica.setBounds(218, 223, 97, 23);
		add(politica);
		
		JCheckBox internac = new JCheckBox("Internacional");
		internac.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		internac.setForeground(new Color(255, 255, 255));
		internac.setFont(new Font("Tahoma", Font.BOLD, 11));
		internac.setBackground(new Color(30, 144, 255));
		internac.setBounds(592, 223, 115, 23);
		add(internac);
		
		JCheckBox nac = new JCheckBox("Nacional");
		nac.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nac.setFont(new Font("Tahoma", Font.BOLD, 11));
		nac.setForeground(new Color(255, 255, 255));
		nac.setBackground(new Color(30, 144, 255));
		nac.setBounds(468, 223, 97, 23);
		add(nac);
		
		JCheckBox cultura = new JCheckBox("Cultura");
		cultura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cultura.setFont(new Font("Tahoma", Font.BOLD, 11));
		cultura.setForeground(new Color(255, 255, 255));
		cultura.setBackground(new Color(30, 144, 255));
		cultura.setBounds(343, 223, 97, 23);
		add(cultura);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!deportes.isSelected() && !politica.isSelected() && !cultura.isSelected() && !nac.isSelected() && !internac.isSelected()) {
					JOptionPane.showMessageDialog(null, "Marca alguna opción", "Error", 0);
				}
				else {
					GuardarPreferencias.guardar(user.getId(), deportes.isSelected(), politica.isSelected(), cultura.isSelected(), nac.isSelected(), internac.isSelected());
					GuardarPreferencias.cargar();
					ventanaPrincipal.mostrarNoticias(user);
				}
		
			}
		});
		btnNewButton.setBounds(343, 367, 89, 23);
		add(btnNewButton);
		
		
		
	}
}
