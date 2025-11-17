package WaitNotify;

public class SincronizacionWaitNotify {
	
	private static final int NUM_HILOS = 6;
	
	private final static boolean[] flagsArrayHilosFinalizados = new boolean[NUM_HILOS];

	public static void main(String[] args) {
		
		inicializarFlagsArrayHilosFinalizados();
		
		for (int i = 0; i < NUM_HILOS; i++) {
			Runnable hilo = new MensajeroGriego();
			Thread hAux = new Thread(hilo);
			hAux.setName(null);
			
		}
	}

	private static void inicializarFlagsArrayHilosFinalizados() {
		
		for (int i = 0; i<NUM_HILOS; i++) {
			flagsArrayHilosFinalizados[i] = false;
		}
	}

}
