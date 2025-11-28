package logic;

import java.util.ArrayList;
import model.Usuario;

public class GestorUsuario {
	
	public static ArrayList<Usuario> usuarios = new ArrayList<>();
	
	static {
		usuarios.add(new Usuario(1, "Eren", "ilovemikasa", "eren@gmail.com", false, null));
		usuarios.add(new Usuario(2, "Mikasa", "iloveeren", "mikasa@gmail.com", false, null));
		usuarios.add(new Usuario(3, "Levy", "titan", "levy@gmail.com", false, null));
		usuarios.add(new Usuario(4, "Erwin", "giveurhearts", "erwin@gmail.com", true, null));
	}
	
	public static boolean validar(String name, String pass) {
		
		for (Usuario u :usuarios) {
			if (u.getName().equals(name)&& u.getPass().equals(pass)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public static Usuario user(String name, String pass) {
		for (Usuario u :usuarios) {
			if (u.getName().equals(name)&& u.getPass().equals(pass)) {
				return u;
			}
		}
		
		return null;
	}
	
	public static Usuario buscarPorId(int id) {
		
		for (Usuario u :usuarios) {
			if (u.getId() == id) {
				return u;
			}
		}
		
		return null;

	}

}
