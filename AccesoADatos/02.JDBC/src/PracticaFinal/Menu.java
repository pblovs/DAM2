package PracticaFinal;

import java.util.Scanner;

public class Menu {
	
	public static void menuEmpleados(Scanner sc) {
		
        int op;
        do {
            System.out.println("\n----- Gestión de Empleados -----");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Listar empleados");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    Empleado.insertar();
                    System.out.println("Registrar empleado...");
                    break;

                case 2:
                    // modificar datos
                    System.out.println("Modificar empleado...");
                    break;

                case 3:
                    // eliminar
                    System.out.println("Eliminar empleado...");
                    break;

                case 4:
                    Empleado.obtenerTodos();
                    System.out.println("Listado de empleados...");
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (op != 5);
    }
	
	
	
	
	
	
	
	

    
    public static void menuJuguetes(Scanner sc) {
    	
        int op;
        do {
            System.out.println("\n----- Gestión de Juguetes -----");
            System.out.println("1. Registrar juguete");
            System.out.println("2. Modificar juguete");
            System.out.println("3. Eliminar juguete");
            System.out.println("4. Listar juguetes");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Registrar juguete...");
                    break;

                case 2:
                    System.out.println("Modificar juguete...");
                    break;

                case 3:
                    System.out.println("Eliminar juguete...");
                    break;

                case 4:
                    System.out.println("Listado de juguetes...");
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (op != 5);
    }

    
    public static void menuVentas(Scanner sc) {
    	
        int op;
        do {
            System.out.println("\n----- Gestión de Ventas -----");
            System.out.println("1. Realizar venta");
            System.out.println("2. Registrar devolución");
            System.out.println("3. Productos más vendidos (top 5)");
            System.out.println("4. Empleados que más venden");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Realizando venta...");
                    break;

                case 2:
                    System.out.println("Registrando devolución...");
                    break;

                case 3:
                    System.out.println("Mostrando top 5 más vendidos...");
                    break;

                case 4:
                    System.out.println("Mostrando empleados con más ventas...");
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (op != 5);
    }

    
    public static void menuDatosTienda(Scanner sc) {
    	
        int op;
        do {
            System.out.println("\n----- Reportes y Consultas -----");
            System.out.println("1. Juguetes disponibles por stand");
            System.out.println("2. Ventas de un mes específico");
            System.out.println("3. Ventas de un empleado en un mes");
            System.out.println("4. Lista de cambios (con motivo)");
            System.out.println("5. Lista de productos ordenados por precio");
            System.out.println("6. Volver");
            System.out.print("Opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Consultando juguetes por stand...");
                    break;

                case 2:
                    System.out.println("Consultando ventas por mes...");
                    break;

                case 3:
                    System.out.println("Consultando ventas por empleado y mes...");
                    break;

                case 4:
                    System.out.println("Consultando cambios...");
                    break;

                case 5:
                    System.out.println("Listando productos ordenados por precio...");
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (op != 6);
    }
}
