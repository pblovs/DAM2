import javax.swing.JFrame;

public class Ventana extends JFrame{

	public Ventana() {
		
		setTitle("TRANSLATOR EN-ES");
		setResizable(false);
		setBounds(100, 100, 550, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		Panel miPanel = new Panel();
		miPanel.setBounds(0, 0, 550, 350);
		add(miPanel);
	}
	
	
}
