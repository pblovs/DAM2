package ExamenPracticaFicheros;

import java.io.Serializable;

public class Empleado implements Serializable{
	
	int id;
	String nombre;
	String cargo;
	String password;
	
	public Empleado(int id, String nombre, String cargo, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", cargo=" + cargo + ", password=" + password + "]";
	}
	
	
	
}
