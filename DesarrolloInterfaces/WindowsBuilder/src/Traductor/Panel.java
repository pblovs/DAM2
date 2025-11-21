package Traductor;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

public class Panel extends JPanel{
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public Panel() {
		setBackground(new Color(119, 136, 153));
		setLayout(null);
		
		lblNewLabel = new JLabel("TRANSLATOR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Freestyle Script", Font.BOLD, 26));
		lblNewLabel.setBounds(151, 31, 243, 22);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("English - Spanish");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(223, 64, 98, 22);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(207, 216, 131, 31);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(125, 115, 291, 31);
		add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Translate");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(223, 165, 98, 23);
		btnNewButton.addActionListener(new EventoTraducir(textField, lblNewLabel_2));
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(new Color(178, 34, 34));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(e -> System.exit(0));
		btnNewButton_1.setBounds(444, 267, 68, 25);
		add(btnNewButton_1);
		
		
	}
}
