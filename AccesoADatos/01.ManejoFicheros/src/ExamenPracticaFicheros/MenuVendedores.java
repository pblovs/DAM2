package ExamenPracticaFicheros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuVendedores {
	
	public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    
    private static final List<Ticket> tickets = new ArrayList<>();
    
	public static void mostrar(Empleado vendedor) {
		Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println(AMARILLO + "\n===== MENÚ VENDEDOR =====" + RESET);
            System.out.println(CYAN + "1. Ver catálogo de plantas" + RESET);
            System.out.println(CYAN + "2. Generar venta" + RESET);
            System.out.println(CYAN + "3. Devolver" + RESET);
            System.out.println(CYAN + "4. Salir" + RESET);
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarCatalogo(vendedor, sc);
                    break;
                case 2:
    		        sc.nextLine();
                    generarVenta(vendedor, sc);
                    break;
                case 3:
                	 System.out.print("Introduce el número del ticket a devolver: ");
                	    int numTicket = sc.nextInt();
                	    sc.nextLine();

                	    Ticket ticketDevuelto = null;
                	    for (Ticket t : tickets) {
                	        if (t.getNumeroTicket() == numTicket) {
                	            ticketDevuelto = t;
                	            break;
                	        }
                	    }

                	    if (ticketDevuelto != null) {
                	        GestorTicket.devolverTicket(ticketDevuelto);
                	    } else {
                	        System.out.println(ROJO + "Ticket no encontrado en memoria." + RESET);
                	    }
                	    break;
                default:
                    System.out.println(ROJO + "Saliendo..." + RESET);
            }

        } while (opcion < 4);
	}
	
	private static void mostrarCatalogo(Empleado vendedor, Scanner sc) {
        System.out.println(VERDE + "\n  <<<<<<<< Catálogo de Plantas >>>>>>>>" + RESET);
        System.out.printf(" %-5s %-17s %-10s %-10s\n", "ID", "Nombre", "Precio", "Stock");
        System.out.println("-------------------------------------------");
        for (Planta p : GestorPlantas.getPlantas()) {
            if (p.getCantidad() > 0) { // Solo plantas disponibles
                System.out.printf(" %-5d %-17s %-10.2f %-10d\n",
                        p.getCodigo(), p.getNombre(), p.getPrecio(), p.getCantidad());
            }
        }
        String opcion;
        System.out.println("\n¿quieres realizar una compra? (s/n): ");
        sc.nextLine();
        opcion = sc.nextLine();
        if (opcion.equalsIgnoreCase("s")) {
        	generarVenta(vendedor, sc);
        }
        else {
        	return;
        }
    }
	
	private static void generarVenta(Empleado vendedor, Scanner sc) {
		int numTicket = GestorTicket.obtenerSiguienteNumeroTicket();
		Ticket ticket = new Ticket(numTicket, vendedor.getId(), vendedor.getNombre());
        String opcion;
        
        do {
    		int id = 0;
    		
    		boolean idValido = false;

		    while (!idValido) {
		        System.out.print("Introduce el ID de la planta a comprar: ");
		        String input = sc.nextLine();

		        if (input.matches("^(?:[1-9]|1[0-9]|20)$")) { 
		            id = Integer.parseInt(input);

		            if (GestorPlantas.buscarPlantaPorId(id).getCantidad() > 0) {
			            idValido = true;
		            }
		            else {
		            	System.out.println(AMARILLO+"No hay stock de esa planta"+RESET);
		            }
		        } else {
		            System.out.println(AMARILLO+"ID inválido. Inténtalo de nuevo."+RESET);
		        }
		    }
    		
    		int cant = 0;
    		boolean cantValida = false;
    		Planta p = GestorPlantas.buscarPlantaPorId(id);

		    while (!cantValida) {
		        System.out.print("Introduce la cantidad: ");
		        String input = sc.nextLine();

		        if (input.matches("\\d+")) { // solo dígitos
		            cant = Integer.parseInt(input);
		            if(p.getCantidad() < cant) {
		    			System.out.println("No hay stock suficiente. Stock: "+p.getCantidad());
		    		}
		            else {
			            cantValida = true;
		            }
		        } else {
		            System.out.println(AMARILLO+"Solo se permiten números. Inténtalo de nuevo."+RESET);
		        }
		    }
    		    		
    		ticket.agregarLinea(p, cant);
            System.out.print("¿Desea agregar otra planta? (s/n): ");
            opcion = sc.nextLine();
        } while (opcion.equalsIgnoreCase("s"));
        
        System.out.println("\n RESUMEN DE COMPRA:\n");
        ticket.imprimir();

        System.out.print("\n¿Confirmar compra? (s/n): ");
        String confirmar = sc.nextLine();

        if (!confirmar.equalsIgnoreCase("s")) {
            System.out.println("Venta cancelada");
            return;
        }
        else {
        	for (LineaTicket l : ticket.getLineas()) {
            	Planta p = GestorPlantas.buscarPlantaPorId(l.getCodigoPlanta());
            	p.setCantidad(p.getCantidad()-l.getCantidad());
            }
        	GestorPlantas.guardar("plantas.dat", GestorPlantas.getPlantas());
        	GestorTicket.guardarTicket(ticket);
        	tickets.add(ticket);
        }
        
        
		
	}
	
}
