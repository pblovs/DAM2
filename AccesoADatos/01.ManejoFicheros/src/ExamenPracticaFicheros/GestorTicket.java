package ExamenPracticaFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GestorTicket {
	private static final String TICKETS_DIR = "TICKETS";
    private static final String DEVOLUCIONES_DIR = "DEVOLUCIONES";

    public static int obtenerSiguienteNumeroTicket() {
        File dir = new File(TICKETS_DIR);
        if (!dir.exists()) dir.mkdirs();

        File contadorFile = new File(dir, "contador.txt");
        int ultimoNumero = 0;

        // Leer el último número guardado
        if (contadorFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(contadorFile))) {
                String linea = br.readLine();
                if (linea != null && !linea.isEmpty()) {
                    ultimoNumero = Integer.parseInt(linea.trim());
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }

        // Incrementar y guardar el nuevo número
        int nuevoNumero = ultimoNumero + 1;
        try (PrintWriter pw = new PrintWriter(new FileWriter(contadorFile))) {
            pw.println(nuevoNumero);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nuevoNumero;
    }


    public static void guardarTicket(Ticket ticket) {
        String carpeta = ticket.isEsDevolucion() ? DEVOLUCIONES_DIR : TICKETS_DIR;
        File dir = new File(carpeta);
        if (!dir.exists()) dir.mkdirs();

        File archivo = new File(dir, ticket.getNumeroTicket() + ".txt");

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
        	pw.println(" Ticket " + ticket.getNumeroTicket() +"          Atendido por: " + ticket.getNombreEmpleado() +
        			" (" + ticket.getIdEmpleado() + ")");
            pw.println("__________________________________________________\n");
            pw.printf(" %-3s %-15s %-4s %10s %12s%n", "nº", "Nombre", "Cant.", "P/Ud.", "Subtotal");
            pw.println("---------------------------------------------------");
            for (LineaTicket l : ticket.getLineas()) {
                pw.println(l.toString());
            }
            pw.println("---------------------------------------------------");
            pw.printf(" TOTAL = %.2f €%n", ticket.getTotal());

            if (ticket.isEsDevolucion()) {
                pw.println();
                pw.println("=== DEVOLUCIÓN ===");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void devolverTicket(int numeroTicket) {
        File original = new File(TICKETS_DIR + "/" + numeroTicket + ".txt");
        File devolucionesDir = new File(DEVOLUCIONES_DIR);
        if (!devolucionesDir.exists()) devolucionesDir.mkdirs();

        File devuelto = new File(devolucionesDir, numeroTicket + ".txt");

        if (!original.exists()) {
            System.out.println("El ticket " + numeroTicket + " no existe.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(original)); //Lee el original y escribe en el devuelto
             PrintWriter pw = new PrintWriter(new FileWriter(devuelto))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                pw.println(linea);
            }
            pw.println();
            pw.println("=== DEVUELTO ===");

        } catch (IOException e) {
            e.printStackTrace();
        }

        original.delete();
        System.out.println("Ticket " + numeroTicket + " devuelto");
    }
}
