
public class LanzaHilos01 {

	public static void main(String[] args) {
		
		Hilo01 hilo1 = new Hilo01("H1");
		Thread h1 = new Thread(hilo1);
		
		Hilo01 hilo2 = new Hilo01("H2");
		Thread h2 = new Thread(hilo2);
		
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Hilo principal terminado.");
	}

}
