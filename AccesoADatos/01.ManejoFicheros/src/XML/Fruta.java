package XML;

import java.util.List;

public class Fruta {
	String nombre;
    String tipo;
    String color;
    String origen;
    String precio;
    String temporada;
    List<String> nutrientes;
    
	public Fruta(String nombre, String tipo, String color, String origen, String precio, String temporada,
			List<String> nutrientes) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.color = color;
		this.origen = origen;
		this.precio = precio;
		this.temporada = temporada;
		this.nutrientes = nutrientes;
	}

	@Override
	public String toString() {
		return "Fruta [nombre=" + nombre + ", tipo=" + tipo + ", color=" + color + ", origen=" + origen + ", precio="
				+ precio + ", temporada=" + temporada + ", nutrientes=" + nutrientes + "]";
	}
    
    
}
