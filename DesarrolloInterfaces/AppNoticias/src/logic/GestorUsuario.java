package logic;

import java.util.ArrayList;
import model.Usuario;

public class GestorUsuario {
	
	public static ArrayList<Usuario> usuarios = new ArrayList<>();
	
	static {
		usuarios.add(new Usuario("Eren", "ilovemikasa", "eren@gmail.com", false, null));
		usuarios.add(new Usuario("Mikasa", "iloveeren", "mikasa@gmail.com", false, null));
		usuarios.add(new Usuario("Levy", "titan", "levy@gmail.com", false, null));
		usuarios.add(new Usuario("Erwin", "giveurhearts", "erwin@gmail.com", true, null));
	}
	
	public static boolean validar(String name, String pass) {
		
		for (Usuario u :usuarios) {
			if (u.getName().equals(name)&& u.getPass().equals(pass)) {
				return true;
			}
		}
		
		return false;
		
	}

}
