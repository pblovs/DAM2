package Interbloqueo;

public class Banco01 {

	public static void main(String[] args) {
		
		try {
			Cuenta01 c1 = new Cuenta01(1, 1000);
	        Cuenta01 c2 = new Cuenta01(2, 1000);

	        // Un hilo transfiere de c1 -> c2
	        Thread t1 = new Thread(new Transferencia01(c1, c2, 1));
	        // El otro transfiere de c2 -> c1
	        Thread t2 = new Thread(new Transferencia01(c2, c1, 1));

	        t1.start();
	        t2.start();

	        t1.join();
	        t2.join();

	        System.out.println("Saldo final C1: " + c1.getSaldo());
	        System.out.println("Saldo final C2: " + c2.getSaldo());
	        System.out.println("Transferencias completadas.");
		}
		catch (InterruptedException e) {
            System.out.println("Error: el hilo fue interrumpido.");
            e.printStackTrace();
        }
		

	}

}
