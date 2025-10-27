package ExamenPracticaFicheros;

import java.io.Serializable;

public class Planta implements Serializable{
	int codigo;
	String nombre;
	String foto;
	String descripcion;
	float precio;
	int cantidad;
	
	public Planta(int codigo, String nombre, String foto, String descripcion, float precio, int cantidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.foto = foto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return String.format(" %-4d %-15s %-20s %-55s %10.2f %15d",
	            codigo, nombre, foto, descripcion, precio, cantidad);
	}
	
	
	
	
}
