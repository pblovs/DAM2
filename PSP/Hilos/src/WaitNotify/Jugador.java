package WaitNotify;

import java.util.concurrent.Semaphore;

public class Jugador implements Runnable {

    
    private final static Semaphore Sem1 = new Semaphore(1);
    private final static Semaphore Sem2 = new Semaphore(0);

    private String tipo; 

    public Jugador(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            if(tipo.equals("PING")) {
                try {
                    Sem1.acquire();
                    System.out.println(tipo);                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Sem2.release();
                }
            }
            else {
            	try {
                    Sem2.acquire();
                    System.out.println(tipo);                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Sem1.release();
                }
            }
        }
    }
}

