package Interbloqueo;

public class Transferencia01 implements Runnable{
	
	private final Cuenta01 origen;
    private final Cuenta01 destino;
    private final double cantidad;
    
	public Transferencia01(Cuenta01 origen, Cuenta01 destino, double cantidad) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.cantidad = cantidad;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
            transferir(origen, destino, cantidad);
        }
	}
    
	private void transferir(Cuenta01 c1, Cuenta01 c2, double cantidad) {
        synchronized (c1) { // Bloquea primera cuenta
            synchronized (c2) { // Luego bloquea la segunda
                if (c1.getSaldo() >= cantidad) {
                    c1.retirar(cantidad);
                    c2.ingresar(cantidad);
                }
            }
        }
    }
    
}
