package ExamenPracticaFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GestorTicket {
	private static final String TICKETS_DIR = "TICKETS";
    private static final String DEVOLUCIONES_DIR = "DEVOLUCIONES";
    private static final String FICHERO_LISTA_TICKETS = "DATOS/tickets_lista.dat"; 
    
    
    
    private static ArrayList<Ticket> tickets = cargarTickets();
    
    @SuppressWarnings("unchecked")
    private static ArrayList<Ticket> cargarTickets() {
        File archivo = new File(FICHERO_LISTA_TICKETS);
        
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<Ticket>) ois.readObject(); 
        } catch (Exception e) {
            System.err.println("Error al cargar la lista de tickets: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    public static void guardarListaCompleta() {
        File dir = new File("DATOS"); 
        if (!dir.exists()) dir.mkdirs();
        
        File archivo = new File(FICHERO_LISTA_TICKETS);
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(tickets); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int obtenerSiguienteNumeroTicket() {
        File dir = new File(TICKETS_DIR);
        if (!dir.exists()) dir.mkdirs();

        File contadorFile = new File(dir, "contador.txt");
        int ultimoNumero = 0;

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

    public static void devolverTicket(Ticket ticket) {
        ticket.marcarComoDevolucion(); 

        guardarTicket(ticket);       
        
        File originalTxt = new File(TICKETS_DIR + "/" + ticket.getNumeroTicket() + ".txt");
        if (originalTxt.exists()) originalTxt.delete();

        GestorPlantas.actualizarStockPorDevolucion(ticket);

        guardarListaCompleta(); 

        System.out.println("Ticket " + ticket.getNumeroTicket() + " devuelto y stock actualizado.");
    }
    
    public static ArrayList<Ticket> getTickets() {
        return tickets;
    }

}
