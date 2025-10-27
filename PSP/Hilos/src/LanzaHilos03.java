
public class LanzaHilos03 {

	public static void main(String[] args) {
		
		int numZonas = 5;
		ResultadosEncuesta resultados = new ResultadosEncuesta(numZonas);
		
        Thread[] hilos = new Thread[numZonas];
        
        for (int i = 0; i < numZonas; i++) {
			Thread h = new Thread(new Hilo03(i + 1, resultados));
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
		
		resultados.mostrarRespuestas();
		resultados.mostrarRespuestasPorZona();
	}

}
