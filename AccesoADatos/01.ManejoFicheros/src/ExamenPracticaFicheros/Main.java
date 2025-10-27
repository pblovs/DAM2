package ExamenPracticaFicheros;

public class Main {

	public static void main(String[] args) {
		System.out.printf("%70s","<<<<<<<< PLANTAS >>>>>>>>\n\n");
		System.out.printf(" %-4s %-15s %-20s %-55s %10s %15s \n", "ID","Nombre","Foto","Descripción","Precio","Cantidad");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		GestorPlantas.cargarPlantas();
		System.out.printf("\n%70s","<<<<<<<< EMPLEADOS >>>>>>>>\n\n");
		/*if (GestorEmpleados.cargarEmpleados().isEmpty()) {
	            GestorEmpleados.agregarEmpleado(new Empleado(1, "Paco", "Jefe", "fowe8fj8"));
	            GestorEmpleados.agregarEmpleado(new Empleado(2, "Alfredo", "Novato", "ghg8433"));
	        }*/
		GestorEmpleados.mostrarEmpleados();

	}

}
