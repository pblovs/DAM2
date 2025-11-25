package model;

import java.util.ArrayList;

public class Usuario {
	
	private String name;
	private String pass;
	private String email;
	private boolean isAdmin = false;
	private ArrayList<Preferencia> prefs = new ArrayList<>();
	
	public Usuario(String name, String pass, String email, boolean isAdmin, ArrayList<Preferencia> prefs) {
		super();
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.isAdmin = isAdmin;
		this.prefs = prefs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public ArrayList<Preferencia> getPrefs() {
		return prefs;
	}

	public void setPrefs(ArrayList<Preferencia> prefs) {
		this.prefs = prefs;
	}

	@Override
	public String toString() {
		return "Usuario [name=" + name + ", pass=" + pass + ", email=" + email + ", isAdmin=" + isAdmin + ", prefs="
				+ prefs + "]";
	}
	
	
}
