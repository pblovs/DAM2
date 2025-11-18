package WaitNotify;

public class SincronizacionWaitNotify {
	
	private static final int NUM_HILOS = 6;
	
	private final static boolean[] flagsArrayHilosFinalizados = new boolean[NUM_HILOS];

	public static void main(String[] args) {
		
		inicializarFlagsArrayHilosFinalizados();
		
		for (int i = 0; i < NUM_HILOS; i++) {
			Runnable hilo = new MensajeroGriego();
			Thread t = new Thread(hilo);
			t.setName(String.valueOf(i));
			t.start();
		}
		
			synchronized (flagsArrayHilosFinalizados) {
				try {
	                while (!todosAcabaron()) {
	                    flagsArrayHilosFinalizados.wait();
	                }
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }			
						
			}
			
			System.out.println("ANUNCIAMOS QUE TODOS LOS HILOS ACABARON LA CARRERA");
	}
		


	private static void inicializarFlagsArrayHilosFinalizados() {
		
		for (int i = 0; i<NUM_HILOS; i++) {
			flagsArrayHilosFinalizados[i] = false;
		}
	}
	
	public static boolean[] getFlagsArrayhilosFinalizados() {
		return flagsArrayHilosFinalizados;
	}
	
	private static boolean todosAcabaron() {
        for (boolean fin : flagsArrayHilosFinalizados) {
            if (!fin) return false;
        }
        return true;
    }

}
