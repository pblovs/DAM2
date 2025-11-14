package Ventanas;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TraductorVentana {

	private JFrame frame;
	private JTextField textField;
	
	String palabra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraductorVentana window = new TraductorVentana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public TraductorVentana(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("TRANSLATOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(148, 11, 165, 23);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(132, 119, 165, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(132, 165, 165, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		palabra = textField.getText();
		
		
		
		JButton btnNewButton = new JButton("Translate");
		btnNewButton.setVisible(false);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String web = "https://www.spanishdict.com/translate/"+palabra;
					Document doc = Jsoup.connect(web).get();
					Element el = doc.select("div#quickdef1-en a.tCur1iYh").get(0);
					String a = el.html().toUpperCase();
					lblNewLabel_1.setText(a);
				}
				catch(IOException e1){
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(311, 118, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		if(palabra != null) {
			btnNewButton.setVisible(true);
		}
		
		JLabel lblNewLabel_2 = new JLabel("English-Spanish");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(148, 37, 129, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(349, 227, 75, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
	
	}
}
