
public class Contador02 {
	int contador;

	public Contador02(int contador) {
		super();
		this.contador = contador;
	}

	synchronized public int getContador() {
		return contador;
	}

	synchronized public void setContador(int contador) {
		this.contador = contador;
	}
	
	synchronized public void incrementar() {
		this.contador++;
	}
}
