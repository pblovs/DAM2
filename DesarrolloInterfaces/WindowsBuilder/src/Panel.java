import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Panel extends JPanel{
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	JButton btnNewButton;
	JButton btnNewButton_1;

	public Panel() {
		setLayout(null);
		
		lblNewLabel = new JLabel("TRANSLATOR ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(161, 31, 126, 22);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("English - Spanish");
		lblNewLabel_1.setBounds(183, 53, 80, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(141, 110, 169, 31);
		add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Translate");
		btnNewButton.setBounds(183, 152, 89, 23);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(372, 266, 68, 23);
		add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(161, 212, 131, 31);
		add(lblNewLabel_2);
	}
}
