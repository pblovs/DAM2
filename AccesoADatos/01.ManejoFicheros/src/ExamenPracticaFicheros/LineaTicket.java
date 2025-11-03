package ExamenPracticaFicheros;

import java.io.Serializable;

public class LineaTicket implements Serializable{
	
	private int codigoPlanta;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    
	public LineaTicket(int codigoPlanta, int cantidad, double precioUnitario, double subtotal) {
		super();
		this.codigoPlanta = codigoPlanta;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
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
	    return String.format("LineaTicket [codigoPlanta=%d, cantidad=%d, precioUnitario=%.2f, subtotal=%.2f]",
	            codigoPlanta, cantidad, precioUnitario, subtotal);
	}

    
    
}
