package ExamenPracticaFicheros;

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
            System.out.println(CYAN + "3. Dar de alta empleado" + RESET);
            System.out.println(CYAN + "4. Modificar planta" + RESET);
            System.out.println(CYAN + "5. Dar de baja empleado" + RESET);
            System.out.println(CYAN + "6. Recuperar empleado" + RESET);
            System.out.println(CYAN + "7. Estadísticas" + RESET);
            System.out.println(CYAN + "8. Salir" + RESET);

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
                	
                	break;
                case 4:
                	break;
                case 5:
                	break;
                case 6:
                	break;
                case 7:
                	break;
                default:
                    System.out.println(ROJO + "Saliendo..." + RESET);
            }

        } while (opcion < 8);
        
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
		GestorPlantas.getPlantasBaja().add(p);
		p.setPrecio(0);
		p.setCantidad(0);
		GestorPlantas.guardar("plantas.dat", GestorPlantas.getPlantas());              
		GestorPlantas.guardarXML("plantas.xml", GestorPlantas.getPlantas());          
		GestorPlantas.guardar("plantasBaja.dat", GestorPlantas.getPlantasBaja());  
		GestorPlantas.guardarXML("plantasBaja.xml", GestorPlantas.getPlantasBaja());

	}

}
