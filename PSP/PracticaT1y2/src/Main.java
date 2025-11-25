import java.io.File;
import java.io.FileOutputStream;

public class Main {

    public static FileOutputStream fosSalida;
    public static String ganador = "";

    public static void main(String[] args) {

        try {
            File f = new File("salida.txt");
            if (f.exists()) {
            	f.delete();
            }

            fosSalida = new FileOutputStream("salida.txt", true);

            Jugador cifras = new Jugador("CIFRAS", true);
            Jugador letras = new Jugador("LETRAS", false);

            cifras.start();
            letras.start();

            cifras.join();
            letras.join();

            System.out.println("Ganador: " + ganador);

            fosSalida.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
