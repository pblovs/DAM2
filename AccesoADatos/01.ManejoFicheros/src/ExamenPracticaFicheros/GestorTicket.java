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

    // === Genera número secuencial de ticket ===
    public static int obtenerSiguienteNumeroTicket() {
        File dir = new File(TICKETS_DIR);
        if (!dir.exists()) dir.mkdirs();

        int maxNumero = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    try {
                        int num = Integer.parseInt(f.getName().replace(".txt", ""));
                        if (num > maxNumero) maxNumero = num;
                    } catch (NumberFormatException ignored) {}
                }
            }
        }
        return maxNumero + 1;
    }

    // === Guarda el ticket como .txt ===
    public static void guardarTicket(Ticket ticket) {
        String carpeta = ticket.isEsDevolucion() ? DEVOLUCIONES_DIR : TICKETS_DIR;
        File dir = new File(carpeta);
        if (!dir.exists()) dir.mkdirs();

        File archivo = new File(dir, ticket.getNumeroTicket() + ".txt");

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            pw.println("Número Ticket: " + ticket.getNumeroTicket());
            pw.println("--------------------------------------------------");
            pw.println("Empleado que ha atendido: " + ticket.getIdEmpleado());
            pw.println("Nombre del empleado: " + ticket.getNombreEmpleado());
            pw.println("Fecha: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            pw.println();
            pw.println("CodigoProducto  Nombre             Cantidad   PrecioUnitario   Subtotal");
            pw.println("--------------------------------------------------");

            for (LineaTicket l : ticket.getLineas()) {
                pw.printf("%-15d %-15s %-10d %-15.2f %-10.2f%n",
                        l.getCodigoPlanta(), l.getNombre(), l.getCantidad(), l.getPrecioUnitario(), l.getSubtotal());
            }

            pw.println("--------------------------------------------------");
            pw.printf("TOTAL: %.2f €%n", ticket.getTotal());

            if (ticket.isEsDevolucion()) {
                pw.println();
                pw.println("=== DEVOLUCIÓN ===");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // === Marcar ticket como devolución ===
    public static void devolverTicket(int numeroTicket) {
        File original = new File(TICKETS_DIR + "/" + numeroTicket + ".txt");
        File devolucionesDir = new File(DEVOLUCIONES_DIR);
        if (!devolucionesDir.exists()) devolucionesDir.mkdirs();

        File devuelto = new File(devolucionesDir, numeroTicket + ".txt");

        if (!original.exists()) {
            System.out.println("❌ El ticket " + numeroTicket + " no existe.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(original));
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

        // Eliminar el ticket original
        original.delete();
        System.out.println("✅ Ticket " + numeroTicket + " movido a DEVOLUCIONES/");
    }
}
