package ExamenPracticaFicheros;

import java.io.Serializable;

public class LineaTicket implements Serializable{
	
	private int codigoPlanta;
	private String nombre;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    
	public LineaTicket(int codigoPlanta, String nombre, int cantidad, double precioUnitario, double subtotal) {
		super();
		this.codigoPlanta = codigoPlanta;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCodigoPlanta() {
		return codigoPlanta;
	}

	public void setCodigoPlanta(int codigoPlanta) {
		this.codigoPlanta = codigoPlanta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
	    return String.format(" %-4d, %-10s, %-8d, %.2f, %.2f",
	            codigoPlanta, nombre, cantidad, precioUnitario, subtotal);
	}

    
    
}
