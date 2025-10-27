import java.util.Random;

public class Hilo01 implements  Runnable{
	
	private final String nombre; //Final es para que no se pueda cambiar el nombre
	
	Hilo01 (String nombre){
		this.nombre = nombre;
	}

	public void run() {
		System.out.printf("Hola, soy un hilo: %s. \n", this.nombre);
		System.out.printf("Hilo %s terminado \n", this.nombre);
		for (int i = 0; i < 5; i++) {
			Random r = new Random();
			int pausa = 20 + r.nextInt(500-20);
			System.out.printf("Hilo %s hace pausa de %d ms.\n", nombre, pausa);
			try {
				Thread.sleep(pausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Hilo %s terminao.\n", nombre);
	}
	
}
