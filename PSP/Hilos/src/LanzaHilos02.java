public class LanzaHilos02 {

	private static final int NUM_HILOS = 10;
	private static final int CUENTA_TOTAL = 100000;

	public static void main(String[] args) {
		
		Thread [] hilos = new Thread[NUM_HILOS];
		Contador02 contadorCompartido = new Contador02(0);

		
		for (int i = 0; i < NUM_HILOS; i++) {
			Hilo02 hilo = new Hilo02("H"+i, CUENTA_TOTAL/NUM_HILOS, contadorCompartido);
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
		
		System.out.println("Cuenta global: "+contadorCompartido.getContador());
	}

}
