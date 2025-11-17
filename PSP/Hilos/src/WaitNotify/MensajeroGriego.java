package WaitNotify;

import java.util.Date;
import java.util.logging.Logger;

public class MensajeroGriego implements Runnable{

	@Override
	public void run() {
		
		//Convierte el nombre del hilo en un entero
		int threadNumber = Integer.parseInt(Thread.currentThread().getName());
		
		//El tiempo se mide en ms desde las 00:00:00 del 1/1/1970
		long tsInicio = new Date().getTime();
		
		System.out.println("COMIENZA LA EJECUCIÓN EL HILO => "+ threadNumber);
		
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("LLEGÓ AL FINAL EL HILO => "+threadNumber);
		
		long tsFin = new Date().getTime();
		
		System.out.println("TARDÉ: "+ (tsFin-tsInicio)/1000.0f+" ms");
		
		registraFinEjecucionHilo(threadNumber);
	}

	protected synchronized void registraFinEjecucionHilo(int threadNumber) {
		
		boolean[] arrayHilosFinalizados = SincronizacionWaitNotify.getFlagsArrayHilosFinalizados();
	}

}
