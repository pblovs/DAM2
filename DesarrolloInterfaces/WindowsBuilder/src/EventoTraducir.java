import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventoTraducir implements ActionListener {
	
	JTextField palabraIn;
	JLabel palabraOut;
	
	public EventoTraducir(JTextField palabraIn, JLabel palabraOut) {
		this.palabraIn = palabraIn;
		this.palabraOut = palabraOut;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(palabraIn.getText().isBlank()!=true) {
			try {
				palabraOut.setText(Operaciones.traducir(palabraIn.getText()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No se ha introducido un texto correcto", "Error", 0);
		}
	}

}
