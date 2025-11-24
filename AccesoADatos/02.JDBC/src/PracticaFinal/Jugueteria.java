package PracticaFinal;

import java.util.Scanner;

public class Jugueteria {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n========= MENU PRINCIPAL =========");
            System.out.println("1. Gestión de empleados");
            System.out.println("2. Gestión de juguetes");
            System.out.println("3. Gestión de ventas");
            System.out.println("4. Obtener datos de la tienda");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Menu.menuEmpleados(sc);
                    break;

                case 2:
                    Menu.menuJuguetes(sc);
                    break;

                case 3:
                    Menu.menuVentas(sc);
                    break;

                case 4:
                    Menu.menuDatosTienda(sc);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        sc.close();
	}

}
