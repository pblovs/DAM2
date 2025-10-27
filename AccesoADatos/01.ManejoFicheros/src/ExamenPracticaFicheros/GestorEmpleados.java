package ExamenPracticaFicheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestorEmpleados {
	
    private static final String FICHERO = "empleados.dat";
    private static ArrayList<Empleado> empleados;
    
    static {
        empleados = cargarEmpleados();
    }

    
    @SuppressWarnings("unchecked")
	static ArrayList<Empleado> cargarEmpleados(){
    	
    	try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))){
    		return (ArrayList<Empleado>) ois.readObject();
    	}
    	catch(IOException | ClassNotFoundException e) {
    		System.out.println("No se pudo leer el fichero, se creará una lista vacía.");
            return new ArrayList<>();
    	}
		
    }
    
    public static void guardar() {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            ous.writeObject(empleados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void agregarEmpleado(Empleado e) {
        empleados.add(e);
        guardar();
    }

    public static void mostrarEmpleados() {
    	for (Empleado e : empleados) {
    		System.out.println(e.toString());
    	}
    }
}
