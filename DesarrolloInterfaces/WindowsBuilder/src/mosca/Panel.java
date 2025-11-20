package mosca;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Panel extends JPanel{
	
	private final int UMBRAL_DISTANCIA = 50; 
    private final int VELOCIDAD = 30;
    
	public Panel() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		ImageIcon icono = new ImageIcon("C:\\Users\\DAM.LAB35-PC\\Downloads\\mosca3.2.png");
		JLabel mosca = new JLabel(icono);
		mosca.setBounds(203, 135, 100, 100);
		
		add(mosca);
		
		JLabel lblNewLabel = new JLabel("MATA LA PUTA MOSCA");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(141, 11, 277, 25);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ASESINALA");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(66, 98, 81, 25);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DESCUARTIZALA");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(67, 237, 100, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("HAZ QUE SUFRA");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(346, 252, 100, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SIN PIEDAD");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(359, 103, 87, 14);
		add(lblNewLabel_4);
		
        addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseMoved(MouseEvent e) {
        		int mouseX = e.getX();
                int mouseY = e.getY();
                int flyX = mosca.getX() + mosca.getWidth() / 2;
                int flyY = mosca.getY() + mosca.getHeight() / 2;

                double distancia = Math.sqrt(Math.pow(mouseX - flyX, 2) + Math.pow(mouseY - flyY, 2)); // Fórmula de la distancia

                if (distancia < UMBRAL_DISTANCIA) {
                    // Calcular la dirección opuesta al cursor
                    int deltaX = (int) ((flyX - mouseX) / distancia * VELOCIDAD);
                    int deltaY = (int) ((flyY - mouseY) / distancia * VELOCIDAD);

                    int nuevaX = flyX + deltaX - mosca.getWidth() / 2;
                    int nuevaY = flyY + deltaY - mosca.getHeight() / 2;

                    // Asegurarse de que la mosca se mantenga dentro de los límites del JFrame
                    nuevaX = Math.max(0, Math.min(getWidth() - mosca.getWidth(), nuevaX));
                    nuevaY = Math.max(0, Math.min(getHeight() - mosca.getHeight(), nuevaY));

                    mosca.setLocation(nuevaX, nuevaY);
                }
        	}
        });

	}
}
