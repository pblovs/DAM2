package ExamenPracticaFicheros;

import java.util.Scanner;

public class Main {
	
	public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.printf(VERDE+"\n%70s","<<<<<<<< PLANTAS >>>>>>>>\n\n"+RESET);
		System.out.printf(" %-4s %-15s %-20s %-55s %10s %15s \n", "ID","Nombre","Foto","Descripción","Precio","Cantidad");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		GestorPlantas.cargarPlantas();
		
		System.out.printf(CYAN+"\n%70s","<<<<<<<< EMPLEADOS >>>>>>>>\n\n"+RESET);
		System.out.printf(" %-8s %-22s %-16s %-20s\n","ID","Nombre","Cargo","Password");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		GestorEmpleados.mostrarEmpleados();
		
		System.out.println("\n\n| Iniciar sesión |\n");
		int intentos = 3;
		Boolean validacion = false;
		int id = -1;
		
		do {
			
			
		    boolean idValido = false;

		    while (!idValido) {
		        System.out.print("ID: ");
		        String input = sc.nextLine();

		        if (input.matches("\\d+")) { // solo dígitos
		            id = Integer.parseInt(input);
		            idValido = true;
		        } else {
		            System.out.println(AMARILLO+"Solo se permiten números. Inténtalo de nuevo."+RESET);
		        }
		    }
		    
		    String pass = "";
		    boolean passValido = false;

		    while (!passValido) {
		        System.out.print("Password: ");
		        pass = sc.nextLine();

		        if (pass.matches(".{5,7}")) {
		            passValido = true;
		        } else {
		            System.out.println(AMARILLO+"La contraseña debe tener entre 5 y 7 caracteres."+RESET);
		        }
		    }
		    
			for (Empleado e : GestorEmpleados.getEmpleados()) {
				if (id == e.getId() && e.getPassword().contentEquals(pass)) {
					validacion = true;
					System.out.println(VERDE+"Bienvenido "+e.getNombre()+"!!"+RESET);
					
					if(e.getCargo().contains("Gestor")) {
						//Menu gestores
					}
					else if(e.getCargo().contains("Vendedor")) {
						//Menu vendedores
					}
				}
			}
			if (!validacion) {
                intentos--;
                System.out.println(ROJO+"Credenciales incorrectas. Te quedan " + intentos + " intento(s)."+RESET);
            }
		} while(intentos > 0 && !validacion);
		
		if (!validacion) {
            System.out.println(ROJO+"\nHas agotado los intentos. Acceso denegado."+RESET);
            System.exit(0);
        }
		
		
		sc.close();
	}

}
