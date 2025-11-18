package WaitNotify;

import java.util.concurrent.Semaphore;

public class PingPong{



	
    public static void main(String[] args) {

    	Thread ping = new Thread(new Jugador("PING"));
        Thread pong = new Thread(new Jugador("PONG"));
        
        ping.start();
        pong.start();
    }

}
