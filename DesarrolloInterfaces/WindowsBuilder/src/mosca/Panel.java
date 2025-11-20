package mosca;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Panel extends JPanel{
	
	private final int UMBRAL_DISTANCIA = 50; 
    private final int VELOCIDAD = 30;
    
	public Panel() {
		setBackground(new Color(119, 136, 153));
		setLayout(null);
		
		ImageIcon icono = new ImageIcon("C:\\Users\\DAM.LAB35-PC\\Downloads\\mosca3.2.png");
		JLabel mosca = new JLabel(icono);
		mosca.setBounds(203, 135, 100, 100);
		
		add(mosca);
		
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
