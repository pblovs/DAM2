package email;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel extends JPanel{
	public Panel() {
		setBackground(new Color(135, 206, 250));
		setLayout(null);
		
		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operaciones.crearEmail();
			}
		});
		btnNewButton.setBounds(334, 296, 109, 37);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ENVIAR EMAIL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(243, 85, 292, 58);
		add(lblNewLabel);
	}
}
