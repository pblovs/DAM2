
public class Hilo02 implements Runnable {
	
	private final String nombre; //Final es para que no se pueda cambiar el nombre
	int incrementos, miCuenta = 0;
	private final Contador02 cont;
	
	public Hilo02(String nombre, int incrementos, Contador02 contadorCompartido) {
		super();
		this.nombre = nombre;
		this.incrementos = incrementos;
		this.cont = contadorCompartido;
	}
	
	public void run() {
		for (int i = 0; i < incrementos; i++) {
			cont.incrementar();
			miCuenta++;
		}
		System.out.println("Hilo "+nombre+" ha terminado. Cuenta: "+ getCuenta());
	}
	
	synchronized public int getCuenta() {
		return miCuenta;
	}
	
	
}
