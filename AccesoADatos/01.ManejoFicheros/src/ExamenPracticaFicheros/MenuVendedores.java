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
                    mostrarCatalogo();
                    break;
                case 2:
                    generarVenta(vendedor, sc);
                    break;
                case 3:
                    System.out.println(VERDE + "Devolver" + RESET);
                    break;
                default:
                    System.out.println(ROJO + "Saliendo..." + RESET);
            }

        } while (opcion < 4);
	}
	
	private static void mostrarCatalogo() {
        System.out.println(VERDE + "\n  <<<<<<<< Catálogo de Plantas >>>>>>>>" + RESET);
        System.out.printf(" %-5s %-17s %-10s %-10s\n", "ID", "Nombre", "Precio", "Stock");
        System.out.println("-------------------------------------------");
        for (Planta p : GestorPlantas.getPlantas()) {
            if (p.getCantidad() > 0) { // Solo plantas disponibles
                System.out.printf(" %-5d %-17s %-10.2f %-10d\n",
                        p.getCodigo(), p.getNombre(), p.getPrecio(), p.getCantidad());
            }
        }
    }
	
	private static void generarVenta(Empleado vendedor, Scanner sc) {
		Ticket ticket = new Ticket(0, vendedor.getId(), vendedor.getNombre());
        String opcion;
        do {
        	System.out.println("Introduce el ID de la planta a comprar: ");
    		int id = sc.nextInt();
    		System.out.println("Introduce la cantidad: ");
    		int cant = sc.nextInt();
    		sc.nextLine();
    		
    		Planta p = GestorPlantas.buscarPlantaPorId(id);
    		if(p.getCantidad() < cant) {
    			System.out.println("No hay stock suficiente. Stock: "+p.getCantidad());
    			return;
    		}
    		ticket.agregarLinea(p, cant);
            System.out.print("¿Desea agregar otra planta? (s/n): ");
            opcion = sc.nextLine();
        } while (opcion.equalsIgnoreCase("s"));
        
        System.out.println("\n RESUMEN DE COMPRA:");
        System.out.println(ticket.toString());
        for (LineaTicket l : ticket.getLineas()) {
            System.out.println(l.toString());
        }
        System.out.printf("TOTAL = %.2f €\n", ticket.getTotal());

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
        	GestorPlantas.guardar();
        }
        
		
	}
	
}
