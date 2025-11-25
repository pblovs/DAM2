package ui;

import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class InicioSesion extends JPanel{
	
	JLabel inicio;
	private JTextField txtNombre;
	private JPasswordField passwordField;

	public InicioSesion() {
		setBackground(new Color(30, 144, 255));
		setLayout(null);
		
		inicio = new JLabel("INICIAR SESIÓN");
		inicio.setForeground(new Color(255, 255, 255));
		inicio.setHorizontalAlignment(SwingConstants.CENTER);
		inicio.setFont(new Font("Tahoma", Font.BOLD, 30));
		inicio.setBounds(257, 131, 269, 37);
		add(inicio);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Name");
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombre.setBounds(266, 296, 250, 30);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(266, 270, 77, 14);
		add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setBounds(266, 361, 91, 14);
		add(lblContrasea);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setFont(new Font("Splash", Font.BOLD, 18));
		btnNewButton.setBounds(315, 463, 150, 37);
		add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Ocultar");
		rdbtnNewRadioButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnNewRadioButton.setBackground(new Color(30, 144, 255));
		rdbtnNewRadioButton.setBounds(537, 386, 67, 29);
		add(rdbtnNewRadioButton);
		
		if(passwordField.getEchoChar() == '*'){
		       passwordField.setEchoChar((char)0);
		    }else{
		        passwordField.setEchoChar('*');
		    }
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(266, 386, 250, 30);
		add(passwordField);
	}
}
