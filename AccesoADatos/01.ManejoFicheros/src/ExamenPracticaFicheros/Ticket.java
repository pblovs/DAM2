package ExamenPracticaFicheros;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable{
	
	private int numeroTicket;
    private int idEmpleado;
    private String nombreEmpleado;
    private boolean esDevolucion;
    private List<LineaTicket> lineas;
    private double total;
    
    public Ticket(int numeroTicket, int idEmpleado, String nombreEmpleado) {
        this.numeroTicket = numeroTicket;
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.esDevolucion = false;
        this.lineas = new ArrayList<>();
        this.total = 0;
    }
	
    public void agregarLinea(Planta p, int cantidad) {
        double subtotal = p.getPrecio() * cantidad;
        lineas.add(new LineaTicket(p.getCodigo(), p.getNombre(),cantidad, p.getPrecio(), subtotal));
        total += subtotal;
    }
    

    public void marcarComoDevolucion() {
        this.esDevolucion = true;
        this.total = -Math.abs(this.total); // lo convierte en negativo
    }

	public int getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(int numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public boolean isEsDevolucion() {
		return esDevolucion;
	}

	public void setEsDevolucion(boolean esDevolucion) {
		this.esDevolucion = esDevolucion;
	}

	public List<LineaTicket> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaTicket> lineas) {
		this.lineas = lineas;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return " Empleado " + idEmpleado + ", "+ nombreEmpleado;
	}
    
	public void imprimir() {
		System.out.println("Ticket "+getNumeroTicket()+"          Atendido por: "+getNombreEmpleado()+" ("+getIdEmpleado()+")");
		System.out.println("_________________________________________________\n");
		
        for (LineaTicket l : getLineas()) {
            System.out.println(l.toString());
        }
        System.out.println("-------------------------------------------------");
        System.out.printf("TOTAL = %.2f €\n", getTotal());
	}
    
}
