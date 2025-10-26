package ExamenPracticaFicheros;

public class Main {

	public static void main(String[] args) {
		System.out.println("---- PLANTAS ----");
		GestorPlantas.cargarPlantas();
		System.out.println("---- EMPLEADOS ----");
		/*if (GestorEmpleados.cargarEmpleados().isEmpty()) {
	            GestorEmpleados.agregarEmpleado(new Empleado(1, "Paco", "Jefe", "fowe8fj8"));
	            GestorEmpleados.agregarEmpleado(new Empleado(2, "Alfredo", "Novato", "ghg8433"));
	        }*/
		GestorEmpleados.mostrarEmpleados();

	}

}
