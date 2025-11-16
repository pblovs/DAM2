package ExamenPracticaFicheros;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuGestores {
	
	public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
	
	public static void mostrar(Empleado gestor) {
		Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println(AMARILLO + "\n===== MENÚ GESTOR =====" + RESET);
            System.out.println(CYAN + "1. Dar de alta planta" + RESET);
            System.out.println(CYAN + "2. Dar de baja planta" + RESET);
            System.out.println(CYAN + "3. Modificar planta" + RESET);
            System.out.println(CYAN + "4. Dar de alta empleado" + RESET);
            System.out.println(CYAN + "5. Dar de baja empleado" + RESET);
            System.out.println(CYAN + "6. Recuperar empleado" + RESET);
            System.out.println(CYAN + "7. Recuperar planta" + RESET);
            System.out.println(CYAN + "8. Estadísticas" + RESET);
            System.out.println(CYAN + "9. Salir" + RESET);

            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                	altaPlanta(sc);
                    break;
                case 2:
                	bajaPlanta(sc);
                    break;
                case 3:
                	modificarPlanta(sc);
                	break;
                case 4:
                	altaEmpleado(sc);
                	break;
                case 5:
                	bajaEmpleado(sc);
                	break;
                case 6:
                	recuperarEmpleado(sc);
                	break;
                case 7:
                	recuperarPlanta(sc);
                	break;
                case 8:
                	mostrarEstadisticas();
                	break;	
                default:
                    System.out.println(ROJO + "Saliendo..." + RESET);
            }

        } while (opcion < 9);
        
        sc.close();
	}
	
	public static void altaPlanta(Scanner sc) {
	    sc.nextLine();
	    System.out.println(VERDE + "\n=== Alta de nueva planta ===" + RESET);
	    System.out.print("Nombre: ");
	    String nombre = sc.nextLine();

	    System.out.print("Descripción: ");
	    String desc = sc.nextLine();

	    System.out.print("Precio: ");
	    float precio = sc.nextFloat();

	    System.out.print("Stock inicial: ");
	    int stock = sc.nextInt();
	    sc.nextLine();

	    int codigo = GestorPlantas.getPlantas().size() + 1;
	    Planta nueva = new Planta(codigo, nombre, nombre + ".jpg", desc, precio, stock);
	    GestorPlantas.getPlantas().add(nueva);
	    GestorPlantas.guardar("plantas.dat", GestorPlantas.getPlantas());
	    GestorPlantas.guardarXML("plantas.xml", GestorPlantas.getPlantas());

	    System.out.println(VERDE + "Planta añadida correctamente." + RESET);
	}
	
	public static void bajaPlanta(Scanner sc) {
	    System.out.println("Introduce el id de la planta: ");
	    int id = sc.nextInt();

	    Planta p = GestorPlantas.buscarPlantaPorId(id);

	    if (p == null) {
	        System.out.println("No existe la planta.");
	        return;
	    }

	    Planta copia = new Planta(p.getCodigo(), p.getNombre(), p.getFoto(), p.getDescripcion(), p.getPrecio(), p.getCantidad());
	    GestorPlantas.getPlantasBaja().add(copia);
	    p.setPrecio(0);
	    p.setCantidad(0);
	    GestorPlantas.guardar("plantas.dat", GestorPlantas.getPlantas());
	    GestorPlantas.guardarXML("plantas.xml", GestorPlantas.getPlantas());
	    GestorPlantas.guardar("plantasBaja.dat", GestorPlantas.getPlantasBaja());
	    GestorPlantas.guardarXML("plantasBaja.xml", GestorPlantas.getPlantasBaja());

	    System.out.println(VERDE + "Planta dada de baja correctamente." + RESET);
	}

	
	public static void modificarPlanta(Scanner sc) {
        System.out.print("Introduce el ID de la planta a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Planta p = GestorPlantas.buscarPlantaPorId(id);
        if (p == null) {
            System.out.println(ROJO + "Planta no encontrada." + RESET);
            return;
        }

        System.out.println("Modificando planta: " + p.getNombre());
        System.out.print("Nuevo nombre (" + p.getNombre() + "): ");
        String nombre = sc.nextLine();
        if (!nombre.isEmpty()) p.setNombre(nombre);

        System.out.print("Nueva descripción (" + p.getDescripcion() + "): ");
        String desc = sc.nextLine();
        if (!desc.isEmpty()) p.setDescripcion(desc);

        System.out.print("Nuevo precio (" + p.getPrecio() + "): ");
        String precioStr = sc.nextLine();
        if (!precioStr.isEmpty()) p.setPrecio(Float.parseFloat(precioStr));

        System.out.print("Nuevo stock (" + p.getCantidad() + "): ");
        String stockStr = sc.nextLine();
        if (!stockStr.isEmpty()) p.setCantidad(Integer.parseInt(stockStr));

        GestorPlantas.guardar("plantas.dat", GestorPlantas.getPlantas());
        GestorPlantas.guardarXML("plantas.xml", GestorPlantas.getPlantas());
        System.out.println(VERDE + "Planta modificada correctamente." + RESET);
    }
	
	public static void altaEmpleado(Scanner sc) {
        sc.nextLine();
        System.out.println(VERDE + "\n=== Alta de nuevo empleado ===" + RESET);
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        String contrasena;
        do {
            System.out.print("Contraseña (5-7 caracteres): ");
            contrasena = sc.nextLine();
        } while (contrasena.length() < 5 || contrasena.length() > 7);

        String cargo;
        do {
            System.out.print("Cargo (gestor/vendedor): ");
            cargo = sc.nextLine().toLowerCase();
        } while (!cargo.equals("gestor") && !cargo.equals("vendedor"));

        int id = (int) (1000 + Math.random() * 9000);
        Empleado nuevo = new Empleado(id, nombre, cargo, contrasena);
        GestorEmpleados.getEmpleados().add(nuevo);
        
        File empleadosDir = new File("EMPLEADOS");
        if (!empleadosDir.exists()) empleadosDir.mkdirs();
        GestorEmpleados.guardar("EMPLEADOS/empleados.dat", GestorEmpleados.getEmpleados());

        System.out.println(VERDE + "Empleado añadido correctamente con ID: " + id + RESET);
    }
	
	public static void bajaEmpleado(Scanner sc) {
        System.out.print("Introduce el ID del empleado: ");
        int id = sc.nextInt();
        sc.nextLine();

        Empleado e = GestorEmpleados.buscarPorId(id);
        if (e == null) {
            System.out.println(ROJO + "No existe ese empleado." + RESET);
            return;
        }

        GestorEmpleados.getEmpleados().remove(e);
        GestorEmpleados.getEmpleadosBaja().add(e);
        
        File empleadosDir = new File("EMPLEADOS");
        if (!empleadosDir.exists()) empleadosDir.mkdirs();
        
        File bajaDir = new File("EMPLEADOS/BAJA");
        if (!bajaDir.exists()) bajaDir.mkdirs();
        
        GestorEmpleados.guardar("EMPLEADOS/empleados.dat", GestorEmpleados.getEmpleados());
        GestorEmpleados.guardar("EMPLEADOS/BAJA/empleadosBaja.dat", GestorEmpleados.getEmpleadosBaja());
        System.out.println(VERDE + "Empleado dado de baja correctamente." + RESET);
    }
	
	public static void recuperarEmpleado(Scanner sc) {
        System.out.print("Introduce el ID del empleado a recuperar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Empleado e = GestorEmpleados.buscarPorIdBaja(id);
        if (e == null) {
            System.out.println(ROJO + "No se encontró ese empleado en BAJA." + RESET);
            return;
        }

        GestorEmpleados.getEmpleadosBaja().remove(e);
        GestorEmpleados.getEmpleados().add(e);
        File empleadosDir = new File("EMPLEADOS");
        if (!empleadosDir.exists()) empleadosDir.mkdirs();
        
        File bajaDir = new File("EMPLEADOS/BAJA");
        if (!bajaDir.exists()) bajaDir.mkdirs();
        GestorEmpleados.guardar("EMPLEADOS/empleados.dat", GestorEmpleados.getEmpleados());
        GestorEmpleados.guardar("EMPLEADOS/BAJA/empleadosBaja.dat", GestorEmpleados.getEmpleadosBaja());
        System.out.println(VERDE + "Empleado recuperado correctamente." + RESET);
    }
	
	public static void recuperarPlanta(Scanner sc) {
	    System.out.print("Introduce el ID de la planta a recuperar: ");
	    int id = sc.nextInt();
	    sc.nextLine();

	    Planta plantaBaja = null;
	    	    
	    for (Planta p : GestorPlantas.getPlantasBaja()) {
	    	if (p.getCodigo() == id) {
	    		plantaBaja = p;
	    		break;
	    	}
	    }

	    if (plantaBaja == null) {
	        System.out.println(ROJO + "No se encontró esa planta en la lista de BAJA." + RESET);
	        return;
	    }

	    Planta plantaPrincipal = GestorPlantas.buscarPlantaPorId(id);
	    if (plantaPrincipal == null) {
	        System.out.println(ROJO + "Error: La planta no existe en la lista principal." + RESET);
	        return;
	    }
	    
	    plantaPrincipal.setPrecio(plantaBaja.getPrecio());
	    plantaPrincipal.setCantidad(plantaBaja.getCantidad());
	    
	    GestorPlantas.getPlantasBaja().remove(plantaBaja);

	    GestorPlantas.guardar("plantas.dat", GestorPlantas.getPlantas());
	    GestorPlantas.guardarXML("plantas.xml", GestorPlantas.getPlantas());
	    GestorPlantas.guardar("plantasBaja.dat", GestorPlantas.getPlantasBaja());
	    GestorPlantas.guardarXML("plantasBaja.xml", GestorPlantas.getPlantasBaja());

	    System.out.println(VERDE + "Planta '" + plantaPrincipal.getNombre() + "' recuperada correctamente." + RESET);
	}
	
	public static void mostrarEstadisticas() {
	    ArrayList<Ticket> tickets = GestorTicket.getTickets();
	    
	    if (tickets.isEmpty()) {
	        System.out.println(AMARILLO + "\nNo hay tickets registrados para calcular estadísticas." + RESET);
	        return;
	    }
	    
	    double totalRecaudado = 0.0;
	    
	    for (Ticket t : tickets) {
	        totalRecaudado += t.getTotal(); 
	    }
	    
	    int maxCantidad = -1;
	    Planta plantaMasVendida = null;

	    for (Planta planta : GestorPlantas.getPlantas()) {

	        int totalVendidas = 0;
	        for (Ticket t : tickets) {
	            for (LineaTicket linea : t.getLineas()) {
	                if (linea.getCodigoPlanta() == planta.getCodigo()) {
	                    totalVendidas += linea.getCantidad();
	                }
	            }
	        }
	        if (totalVendidas > maxCantidad) {
	            maxCantidad = totalVendidas;
	            plantaMasVendida = planta;
	        }
	    }

	    
	    System.out.println(VERDE + "\n===== ESTADÍSTICAS =====" + RESET);
	    
	    System.out.printf(MAGENTA + "Total Recaudado: " + RESET + "%.2f €\n", totalRecaudado);
        System.out.printf(AMARILLO+"Planta más vendida: "+ RESET + "%s\n", plantaMasVendida.getNombre());

	    
	}
	

}
