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
                    break;
                case 2:
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
		String nombre;
		String foto;
		String desc;
		float precio;
		int cant;
		
		System.out.println("Introduce el nombre: ");
		nombre = sc.nextLine();
		foto = nombre +".jpg";
		
		
	}
}
