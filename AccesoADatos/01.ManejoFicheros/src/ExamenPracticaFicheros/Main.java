package ExamenPracticaFicheros;

public class Main {

	public static void main(String[] args) {
		System.out.printf("\n%70s","<<<<<<<< PLANTAS >>>>>>>>\n\n");
		System.out.printf(" %-4s %-15s %-20s %-55s %10s %15s \n", "ID","Nombre","Foto","Descripción","Precio","Cantidad");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		GestorPlantas.cargarPlantas();
		
		System.out.printf("\n%70s","<<<<<<<< EMPLEADOS >>>>>>>>\n\n");
		System.out.printf(" %-20s %-20s %-20s\n", "Nombre","Cargo","Password");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		GestorEmpleados.mostrarEmpleados();

	}

}
