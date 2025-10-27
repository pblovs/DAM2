
public class LanzaHilos04 {

	public static void main(String[] args) {
		
		final int NUM_HILOS = 10;
		final int CUENTA_TOTAL = 100000000;
		
		Thread [] hilos = new Thread[NUM_HILOS];
		Contador04 contadorCompartido = new Contador04();

		
		for (int i = 0; i < NUM_HILOS; i++) {
			Hilo04 hilo = new Hilo04("H"+i, CUENTA_TOTAL/NUM_HILOS, contadorCompartido);
			Thread h = new Thread(hilo);
			h.start();
			hilos[i] = h;
		}
		for (Thread h : hilos) {
			try {
				h.join();
			}
			catch(InterruptedException e) {
				System.out.println("Excepción por interrupción.");
			}
		}
		
		System.out.println("Cuenta global: "+contadorCompartido.getCont1());
	}

}
