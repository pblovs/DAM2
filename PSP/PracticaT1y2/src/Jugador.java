import java.io.FileOutputStream;
import java.util.Random;

public class Jugador extends Thread {

    boolean esCifras;
    Random r = new Random();
    boolean juegoTerminado = false;

    public Jugador(String nombre, boolean esCifras) {
        super(nombre);
        this.esCifras = esCifras;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(r.nextInt(1001));

            for (int i = 0; i < 20 && !juegoTerminado; i++) {

                char c;

                if (esCifras) {
                    c = (char) (48 + r.nextInt(10));   
                } else {
                    c = (char) (65 + r.nextInt(26));   
                }

                Main.fosSalida.write(c);

                if (i == 19) {
                	juegoTerminado = true;
                    Main.ganador = getName();
                }

                Thread.sleep(100); 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
